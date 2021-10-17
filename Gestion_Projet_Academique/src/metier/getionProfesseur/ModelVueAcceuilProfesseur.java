package metier.getionProfesseur;

import java.util.ArrayList;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableEtudiantFORprofesseur;
import metier.gestion.ModeleTableProjet;
import metier.pojo.Etudiant;
import metier.pojo.Projet;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class ModelVueAcceuilProfesseur {

	private DAOEtudiant etudiant;
	private DAOProjet projet;
	private DAODocument document;
	
	public ModeleTableEtudiantFORprofesseur getEtudiantTable(int IDprof) {
		ModeleTableEtudiantFORprofesseur modelEtudiant;
		try {
			ArrayList<Etudiant> etudiants= new ArrayList<Etudiant>();
			etudiant= new DAOEtudiant();
			for(Etudiant d:etudiant.getAll())
			{
				if(d.getId_professeur()==IDprof)
					etudiants.add(d);
			}
			 modelEtudiant = new ModeleTableEtudiantFORprofesseur(etudiants);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		return modelEtudiant;
	}

	public ModeleTableProjet getProjetTable(int IDprof) {
		ModeleTableProjet modelProjet;
		try {
			ArrayList<Projet> Projets= new ArrayList<Projet>();
			projet= new DAOProjet();
			for(Projet d:projet.getAll())
			{
				if(d.getId_professeur()==IDprof)
					Projets.add(d);
			}
			modelProjet = new ModeleTableProjet(Projets);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		return modelProjet;
	}
}
