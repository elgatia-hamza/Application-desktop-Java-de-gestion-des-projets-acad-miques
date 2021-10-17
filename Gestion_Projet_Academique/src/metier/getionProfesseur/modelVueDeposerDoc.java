package metier.getionProfesseur;

import javax.swing.JOptionPane;

import metier.pojo.Document;
import metier.pojo.Etudiant;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class modelVueDeposerDoc {
	
	private DAOEtudiant etudiant;
	private DAODocument document;

	public boolean DeposerDocument(String Titre, String Motcle, int IDprof, String path, String type) {
		Document doc = new Document();

		try {
			etudiant= new DAOEtudiant();
			document= new DAODocument();
			for(Document c: document.getAll())
			{
				if(c.getTitre().equals(Titre))
				{
					JOptionPane.showMessageDialog(null, "document déjà envoyé");
				       return false;
				}
			}
			 for(Etudiant d:etudiant.getAll())
			{
				

				if(d.getId_professeur()==IDprof)
				{
					
					doc.setId_document(document.getAll().size()+1);
					doc.setId_professeur(IDprof);
					doc.setMot_cles(Motcle);
					doc.setPath(path);
					doc.setTitre(Titre);
					doc.setType_document(type);
					doc.setId_etudiant(d.getId_etudiant());
					document.add(doc);
				}
			}

		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "document est envoyé");
		return true;
		
	}

}
