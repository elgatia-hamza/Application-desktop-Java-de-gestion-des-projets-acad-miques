package metier.getionProfesseur;

import metier.pojo.Document;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class modelVueconsulterDocLivrable2 {

	private DAODocument document;
	public String getlivrable(String type_document, String Id_Etdiant) {
		String livrable="Pas Encore!";
		try {
			document= new DAODocument();
			for(Document d: document.getAll())
			{
		
				if(d.getType_document().equals(type_document) && d.getId_etudiant().toString().equalsIgnoreCase(Id_Etdiant))
				{
					livrable= d.getPath();
				}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		return livrable;
		
	}

}
