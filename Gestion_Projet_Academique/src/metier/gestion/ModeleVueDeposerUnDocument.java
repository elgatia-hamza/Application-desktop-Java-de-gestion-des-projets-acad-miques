package metier.gestion;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import metier.pojo.Document;
import metier.pojo.Etudiant;
import metier.pojo.Projet;
import persistance.DAODocument;
import persistance.DAOProjet;

public class ModeleVueDeposerUnDocument {
	private JComboBox typeDocuments;
	private JTextField txtMotsCles;
	private JTextField path;
	private JTextField titre;
	private DAODocument tableDocument;
	private DAOProjet tableProjet;
	private Projet projet;

	private Etudiant etudiant;
	



	public ModeleVueDeposerUnDocument(Etudiant etudiant) throws ClassNotFoundException {
		super();
		this.etudiant = etudiant;
		this.tableDocument= new DAODocument();
		this.tableProjet = new DAOProjet();
		
	}
	public JComboBox getTypeDocuments() {
		return typeDocuments;
	}

	public void setTypeDocuments(JComboBox typeDocuments) {
		this.typeDocuments = typeDocuments;
	}

	public JTextField getTxtMotsCles() {
		return txtMotsCles;
	}

	public void setTxtMotsCles(JTextField txtMotsCles) {
		this.txtMotsCles = txtMotsCles;
	}

	public JTextField getTxtLienDuDocument() {
		return path;
	}

	public void setTxtLienDuDocument(JTextField path) {
		this.path = path;
	}

	public JTextField getTitre() {
		return titre;
	}

	public void setTitre(JTextField titre) {
		this.titre = titre;
	}

	public DAODocument getTableDocument() {
		return tableDocument;
	}

	public void setTableDocument(DAODocument tableDocument) {
		this.tableDocument = tableDocument;
	}

	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public Boolean deposerDocument() {
		if(!isChampsValid(etudiant.getId_etudiant(), (String)typeDocuments.getSelectedItem())) {
			return false;
		}
		
		
		Document document = new Document();	
		document.setId_document(tableDocument.getAll().size()+1);
		document.setMot_cles(txtMotsCles.getText());
		document.setId_etudiant(etudiant.getId_etudiant());
		document.setId_professeur(etudiant.getId_professeur());
		document.setPath(path.getText());
		document.setTitre(titre.getText());
		document.setType_document((String)typeDocuments.getSelectedItem());
		tableDocument.add(document);
		
		Projet projet = new Projet();
		projet = tableProjet.searchById(etudiant.getId_projet());
		projet.setEtat_avencement(projet.getEtat_avencement()+25);
		tableProjet.update(etudiant.getId_projet(), projet);
		return true;
	}
	
	
	
	public boolean isChampsValid(int id_etudiant,String type_document) {
		ArrayList<Document> listDocument = tableDocument.searchById_etudiant(id_etudiant);
		for (Document document : listDocument) {
			if(document.getType_document().equals(type_document))
				return false;
		}

		String[] champs = new String[] {
				txtMotsCles.getText(),
				titre.getText(),
				path.getText()
		};
		
		for (String c : champs) {
		if(c.isEmpty())
				return false;
		}
		
		return true;

	}	
	
	public boolean isChampsexist(int id_etudiant,String type_document, int id_professeur) {
		ArrayList<Document> listDocument = tableDocument.searchById_etudiant(id_etudiant);
		for (Document document : listDocument) {
			if(document.getType_document().equals(type_document) && document.getId_professeur()==id_professeur)
				return false;
		}
		return true;
	}
	
	
}
