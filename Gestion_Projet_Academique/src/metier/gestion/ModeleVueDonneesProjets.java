package metier.gestion;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import metier.pojo.Administrateur;
import metier.pojo.Departement;
import metier.pojo.Etudiant;
import metier.pojo.Filier;
import metier.pojo.Professeur;
import metier.pojo.Projet;
import persistance.DAOEtudiant;
import persistance.DAOFilier;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class ModeleVueDonneesProjets {
	private ModeleTableProjet modelProjet;
	private ModeleTableEtudiant modelEtudiant;
	private ModeleTableProfesseur modelProfesseur;
	private JTextField theme_projetText;
	private JTextField cneText;
	private JTextField id_professeurText;
	private JTextField id_projetText;
	private JComboBox<String> typelist;
	private JTextField clotureText;
	private JTextField dureeText;
	private Administrateur admin;
	private DAOProjet tableProjet;
	private DAOProfesseur tableProfesseur;
	private DAOEtudiant tableEtudiant;
	private DAOFilier tablefilier;

	public ModeleVueDonneesProjets(Administrateur admin) throws ClassNotFoundException {
		super();
		this.admin = admin;
		tableProjet = new DAOProjet();
		tableProfesseur = new DAOProfesseur();
		tableEtudiant = new DAOEtudiant();
		tablefilier = new DAOFilier();
	}

	public ModeleTableProjet getModelProjet() {
		return modelProjet;
	}

	public void setModelProjet(ModeleTableProjet modelProjet) {
		this.modelProjet = modelProjet;
	}

	public ModeleTableEtudiant getModelEtudiant() {
		return modelEtudiant;
	}

	public void setModelEtudiant(ModeleTableEtudiant modelEtudiant) {
		this.modelEtudiant = modelEtudiant;
	}

	public ModeleTableProfesseur getModelProfesseur() {
		return modelProfesseur;
	}

	public void setModelProfesseur(ModeleTableProfesseur modelProfesseur) {
		this.modelProfesseur = modelProfesseur;
	}

	public JTextField getTheme_projetText() {
		return theme_projetText;
	}

	public void setTheme_projetText(JTextField theme_projetText) {
		this.theme_projetText = theme_projetText;
	}

	public JTextField getCneText() {
		return cneText;
	}

	public void setCneText(JTextField cneText) {
		this.cneText = cneText;
	}

	public JTextField getId_professeurText() {
		return id_professeurText;
	}

	public void setId_professeurText(JTextField id_professeurText) {
		this.id_professeurText = id_professeurText;
	}

	public JComboBox<String> getTypelist() {
		return typelist;
	}

	public void setTypelist(JComboBox<String> typelist) {
		this.typelist = typelist;
	}

	public JTextField getClotureText() {
		return clotureText;
	}

	public void setClotureText(JTextField clotureText) {
		this.clotureText = clotureText;
	}

	public JTextField getDureeText() {
		return dureeText;
	}

	public void setDureeText(JTextField dureeText) {
		this.dureeText = dureeText;
	}

	public JTextField getId_projetText() {
		return id_projetText;
	}

	public void setId_projetText(JTextField id_projet) {
		this.id_projetText = id_projet;
	}

	/* Ajouter Projet */
	public boolean add() {
		if (!champsValide()) {
			return false;
		}
		Projet p = new Projet();
		p.setId_projet(modelProjet.getRowCount() + 1);
		p.setTheme_projet(theme_projetText.getText());
		p.setId_professeur(Integer.parseInt(id_professeurText.getText()));
		p.setCloture(clotureText.getText());
		p.setDuree(dureeText.getText());
		p.setRapport(0);
		p.setEtat_avencement(0);
		p.setType((String) typelist.getSelectedItem());
		p.setId_administrateur(admin.getId_administrateur());

		modelProjet.addRow(p);
		tableProjet.add(p);

		Etudiant etudiant = searchEtudiantByCNE(cneText.getText());
		etudiant.setId_projet(p.getId_projet());
		etudiant.setId_professeur(Integer.parseInt(id_professeurText.getText()));
		tableEtudiant.update(etudiant.getId_etudiant(), etudiant);

		return true;
	}

	public Etudiant searchEtudiantByCNE(String cne) {
		ArrayList<Etudiant> listEtudiant = tableEtudiant.getAll();
		for (Etudiant etudiant : listEtudiant) {
			if (etudiant.getCNE().equals(cne)) {
				return etudiant;
			}
		}
		return null;
	}

	public boolean champsValide() {
		if (isChampVide())
			return false;

		if (!isCneValide())
			return false;

		int id_professeur;
		try {
			id_professeur = Integer.parseInt(id_professeurText.getText());
		} catch (NumberFormatException e) {
			System.err.println("id de professeur doit �tre un entier!!");
			return false;
		}

		if (id_professeur < 1 || id_professeur > getListeProfesseurs().size())
			return false;

		if (!clotureText.getText().matches("(20([0-9]{2}))\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])")) {
			System.err.println("Date est invalid");
			return false;
		}
		return true;
	}

	public boolean isChampVide() {
		String[] champs = new String[] { theme_projetText.getText(), id_professeurText.getText(), clotureText.getText(),
				dureeText.getText(), };

		for (String c : champs) {
			if (c.isEmpty())
				return true;
		}
		return false;
	}

	/* Methode pour retourner les lists de tableau */

	public ArrayList<Projet> getListeProjets() {
		return tableProjet.getAll();
	}

	public ArrayList<Professeur> getListeProfesseurs() {
		return tableProfesseur.getAll();
	}

	public ArrayList<Etudiant> getListeEtudiants() {
		return tableEtudiant.getAll();
	}

	/* renitialiser les champs */
	public void reset() {
		JTextField[] champs = new JTextField[] { theme_projetText, id_professeurText, clotureText, dureeText, cneText };
		for (JTextField c : champs) {
			c.setText("");
		}

		typelist.setSelectedIndex(0);
	}

	public boolean isCneValide() {
		String cne = cneText.getText();

		if (!cne.matches("[A-Z]([0-9]{9})"))
			return false;

		ArrayList<Etudiant> listEtudiants = getListeEtudiants();
		for (Etudiant etudiant : listEtudiants) {
			if (cne.equals(etudiant.getCNE()))
				return true;
		}

		return false;
	}

	public boolean rechercheIdProjet() {
		if (id_projetText.getText().isEmpty())
			return false;

		int id_projet;
		try {
			id_projet = Integer.parseInt(id_projetText.getText());
		} catch (NumberFormatException e) {
			System.err.println("id de projet doit �tre un entier!!");
			return false;
		}

		if (id_projet < 1 || id_projet > getListeProjets().size())
			return false;

		return true;
	}

	/* Modifier Projet */
	public boolean mettreAjourProjet() {
		if (!champsValide()) {
			return false;
		}

		Projet p = new Projet();
		p.setId_projet(modelProjet.getRowCount());
		p.setTheme_projet(theme_projetText.getText());
		p.setId_professeur(Integer.parseInt(id_professeurText.getText()));
		p.setCloture(clotureText.getText());
		p.setDuree(dureeText.getText());
		p.setRapport(0);
		p.setEtat_avencement(0);
		p.setType((String) typelist.getSelectedItem());
		p.setId_administrateur(admin.getId_administrateur());

		int id_projet = Integer.parseInt(id_projetText.getText());

		modelProjet.deleteRow(id_projet);
		modelProjet.addRow(p);
		tableProjet.update(id_projet, p);

		return true;
	}

	/* Supprimer Projet */
	public void supprimerProjet() {
		int id = Integer.parseInt(id_projetText.getText());
		Projet p = tableProjet.searchById(id);
		tableProjet.delete(p);
		modelProjet.deleteRow(id);
	}

	/* Statistique : Repporting */
	public float getAvencementTotal() {
		int nombreTotaleProjet = modelProjet.getRowCount();
		ArrayList<Projet> listProjets = tableProjet.getAll();
		float avencementTotal = 0;
		for (Projet projet : listProjets) {
			avencementTotal += projet.getEtat_avencement();
		}

		return (avencementTotal / nombreTotaleProjet);
	}

	public ArrayList<Etudiant> getlistEtudiantIID() {
		ArrayList<Etudiant> listEtudiants = tableEtudiant.getAll();
		ArrayList<Filier> listFiliers = tablefilier.getAll();
		ArrayList<Etudiant> listEtudiantIID = new ArrayList<Etudiant>();

		int idIID = 0;
		for (Filier filier : listFiliers) {
			if (filier.getNom_filier().equals("IID"))
				idIID = filier.getId_filier();
		}

		if (idIID == 0)
			return null;

		for (Etudiant etudiant : listEtudiants) {
			if (etudiant.getId_filier() == idIID)
				listEtudiantIID.add(etudiant);
		}
		return listEtudiantIID;
	}

	public ArrayList<Etudiant> getlistEtudiantGI() {
		ArrayList<Etudiant> listEtudiants = tableEtudiant.getAll();
		ArrayList<Filier> listFiliers = tablefilier.getAll();
		ArrayList<Etudiant> listEtudiantGI = new ArrayList<Etudiant>();

		int idGI = 0;
		for (Filier filier : listFiliers) {
			if (filier.getNom_filier().equals("GI"))
				idGI = filier.getId_filier();
		}

		if (idGI == 0)
			return null;

		for (Etudiant etudiant : listEtudiants) {
			if (etudiant.getId_filier() == idGI)
				listEtudiantGI.add(etudiant);
		}

		return listEtudiantGI;
	}

	public ArrayList<Etudiant> getlistEtudiantGE() {
		ArrayList<Etudiant> listEtudiants = tableEtudiant.getAll();
		ArrayList<Filier> listFiliers = tablefilier.getAll();
		ArrayList<Etudiant> listEtudiantGE = new ArrayList<Etudiant>();

		int idGE = 0;
		for (Filier filier : listFiliers) {
			if (filier.getNom_filier().equals("GE"))
				idGE = filier.getId_filier();
		}

		if (idGE == 0)
			return null;

		for (Etudiant etudiant : listEtudiants) {
			if (etudiant.getId_filier() == idGE)
				listEtudiantGE.add(etudiant);
		}

		return listEtudiantGE;
	}

	public int getAvencementIID() {
		ArrayList<Etudiant> listEtudiantIID = getlistEtudiantIID();
		int etatAvencementIID = 0;
		for (Etudiant etudiant : listEtudiantIID) {
			System.out.println(etudiant);
			if (etudiant.getId_projet() != 0) {
				Projet p = tableProjet.searchById(etudiant.getId_projet());
				etatAvencementIID += p.getEtat_avencement();
			}
		}

		if (etatAvencementIID == 0)
			return 0;

		return (int) (etatAvencementIID / listEtudiantIID.size());
	}

	public int getAvencementGI() {
		ArrayList<Etudiant> listEtudiantGI = getlistEtudiantGI();
		int etatAvencementGI = 0;
		for (Etudiant etudiant : listEtudiantGI) {
			etatAvencementGI += tableProjet.searchById(etudiant.getId_projet()).getEtat_avencement();
		}

		if (etatAvencementGI == 0)
			return 0;

		return (int) (etatAvencementGI / listEtudiantGI.size());
	}

	public int getAvencementGE() {
		ArrayList<Etudiant> listEtudiantGE = getlistEtudiantGE();
		int etatAvencementGE = 0;
		for (Etudiant etudiant : listEtudiantGE) {
			etatAvencementGE += tableProjet.searchById(etudiant.getId_projet()).getEtat_avencement();
		}

		if (etatAvencementGE == 0)
			return 0;

		return (int) (etatAvencementGE / listEtudiantGE.size());
	}
}
