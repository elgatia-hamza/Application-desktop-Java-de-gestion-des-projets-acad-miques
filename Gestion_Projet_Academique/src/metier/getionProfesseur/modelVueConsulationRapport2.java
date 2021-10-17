package metier.getionProfesseur;

import metier.pojo.Document;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class modelVueConsulationRapport2 {


	private DAODocument document;
	
	public String checkRapport(String string) {
		Integer value=Integer.valueOf(string);
		String rapport="Pas Encore!";
		try {
			document= new DAODocument();
			for(Document d: document.getAll())
			{
		
				if(d.getId_etudiant()==value && d.getType_document().equalsIgnoreCase("rapport"))
				{
					rapport= d.getPath();
				}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		return rapport;    

	}


}
