package metier.gestion;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import metier.pojo.Professeur;
import persistance.DAOProfesseur;

public class ModeleVueDonneesProfesseur {
	private ModeleTableProfesseur model;
	private DAOProfesseur listProfesseurs;
	private JTextField idText;
	private JTextField id_departementText;
	private JTextField nomText;
	private JTextField prenomText;
	private JTextField emailText;
	private JTextField passwordText;
	private JComboBox<String> domaine_recherche_list;

	public ModeleVueDonneesProfesseur() {
		super();
	}

	public ModeleVueDonneesProfesseur(ModeleTableProfesseur model, JTextField idText, JTextField id_departementText,
			JTextField nomText, JTextField prenomText, JTextField emailText, JTextField passwordText,
			JComboBox<String> domaine_recherche_list) throws ClassNotFoundException {
		super();
		this.model = model;
		this.idText = idText;
		this.id_departementText = id_departementText;
		this.nomText = nomText;
		this.prenomText = prenomText;
		this.emailText = emailText;
		this.passwordText = passwordText;
		this.domaine_recherche_list = domaine_recherche_list;
		this.listProfesseurs = new DAOProfesseur();
	}
	
	
	public boolean add() {
		if(isChampVide())
			return false;
		Professeur p = new Professeur();
		
		int id_professeur ;
		int id_departement ;
		try {
			id_professeur = Integer.parseInt(idText.getText());
			id_departement = Integer.parseInt(id_departementText.getText());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		p.setId_professeur(id_professeur);
		p.setId_departement(id_departement);
		p.setNom(nomText.getText());
		p.setPrenom(prenomText.getText());
		p.setEmail(emailText.getText());
		p.setLogin(nomText.getText());
		p.setPassword(passwordText.getText());
		p.setDomaine_recherche((String)domaine_recherche_list.getSelectedItem());
		
		System.out.println(p);
		
		model.addRow(p);
		listProfesseurs.add(p);
		return true;
	}
	

	
	public boolean isChampVide() {
		String[] champs = new String[] {
			idText.getText(),
			nomText.getText(),
			prenomText.getText(),
			emailText.getText(),
			passwordText.getText(),
			id_departementText.getText()
		};
		
		for (String c : champs) {
			if(c.isEmpty())
				return true;
		}
		return false;
	}
	
	public void reset() {
		JTextField[] champs = new JTextField[] {
				idText,
				nomText,
				prenomText,
				emailText,
				passwordText,
				id_departementText
			};
		for (JTextField c : champs) {
				c.setText("");
		}
		
		domaine_recherche_list.setSelectedIndex(0);
	}
	
	
	public boolean supprimerProfesseur(Professeur professeur) {
		int id_professeur = professeur.getId_professeur();
		
		int index=0;
		while(index<model.getRowCount()) {
			if((int)model.getValueAt(index, 0)==id_professeur)
				break;
			index++;
		}
		model.deleteRow(index);
		return listProfesseurs.delete(professeur);
	}
	
	public boolean mettreAjourProfesseur(int id) {
		if(isChampVide())
			return false;
		Professeur p = new Professeur();
		
		int id_professeur ;
		int id_departement ;
		try {
			id_professeur = Integer.parseInt(idText.getText());
			id_departement = Integer.parseInt(id_departementText.getText());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		p.setId_professeur(id_professeur);
		p.setId_departement(id_departement);
		p.setNom(nomText.getText());
		p.setPrenom(prenomText.getText());
		p.setEmail(emailText.getText());
		p.setLogin(nomText.getText());
		p.setPassword(passwordText.getText());
		p.setDomaine_recherche((String)domaine_recherche_list.getSelectedItem());
		
		int index=0;
		while(index<model.getRowCount()) {
			if((int)model.getValueAt(index, 0)==id_professeur)
				break;
			index++;
		}
		
		if(listProfesseurs.update(id, p)!=true)
			return false;
		
		model.deleteRow(index);
		model.addRow(p);
		
		
		
		return true;
	}
	
	
}
