package metier.getionProfesseur;

import java.util.ArrayList;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableEtudiantFORprofesseur;
import metier.pojo.Etudiant;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class modelVueconsulterDocLivrable1 {
	
	private DAOEtudiant etudiant;
	
	public ModeleTableEtudiantFORprofesseur geJTableEtudiant(String string, String string2, int IDProf) {
		ModeleTableEtudiantFORprofesseur modelEtudiant;
		try {
			ArrayList<Etudiant> etudiants= new ArrayList<Etudiant>();
			etudiant= new DAOEtudiant();
			for(Etudiant d:etudiant.getEtdiantByTypeFililere(string,string2))
			{
				if(d.getId_professeur()==IDProf)
				{
					etudiants.add(d);
				}
			}
			 modelEtudiant = new ModeleTableEtudiantFORprofesseur(etudiants);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		return modelEtudiant;
		
		
	}
}
