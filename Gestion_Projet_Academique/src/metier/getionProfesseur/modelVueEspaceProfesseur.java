package metier.getionProfesseur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableProjet;
import metier.pojo.Document;
import metier.pojo.Etudiant;
import metier.pojo.Projet;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class modelVueEspaceProfesseur {

	private DAOProfesseur professeur;
	private DAOAdministrateur admin;
	private DAOEtudiant etudiant;
	private DAOProjet projet;
	private DAODocument document;



	public ModeleTableEtudiant geJTableEtudiant(String string, String string2, int IDProf) {
		ModeleTableEtudiant modelEtudiant;
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
			 modelEtudiant = new ModeleTableEtudiant(etudiants);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		return modelEtudiant;
		
		
	}

	public ModeleTableEtudiant getEtudiantTable(int IDprof) {
		ModeleTableEtudiant modelEtudiant;
		try {
			ArrayList<Etudiant> etudiants= new ArrayList<Etudiant>();
			etudiant= new DAOEtudiant();
			for(Etudiant d:etudiant.getAll())
			{
				if(d.getId_professeur()==IDprof)
					etudiants.add(d);
			}
			 modelEtudiant = new ModeleTableEtudiant(etudiants);

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

	public Double getAvancementValueByID(Integer id) {
		Projet p= new Projet();
		Double value=0.00;
		try {
			projet= new DAOProjet();
			if(projet.searchById(id)!=null)
			{
				 p =projet.searchById(id);
                 value=(double)p.getEtat_avencement();
			}
			
		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
			return null;
		}
		return value;
	}

	public Double getAvancementValueByType(String type) {
		double value = 0;
		ArrayList<Integer> values= new ArrayList<Integer>();
		try {
		      	projet= new DAOProjet();
		      	if(projet.getAll()!=null)
		      	{
	                 for(Projet prjt :projet.getAll())	
	                 {
	                	 if(type.equals(prjt.getType()))
	                	 {
	                		 values.add(prjt.getEtat_avencement());
	                	 }
	                 }
	                 double s=0;
	                for(int d :values)
	                {
	                	s=s+d;
	                }
	                value=((double)s)/values.size();
		      	}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return value;
	}

	public Double getAvancementrous() {
		double value = 0;
		ArrayList<Integer> values= new ArrayList<Integer>();
		try {
		      	projet= new DAOProjet();
		      	if(projet.getAll()!=null)
		      	{
	                 for(Projet prjt :projet.getAll())	
	                 {
	                	 
	                	 {
	                		 values.add(prjt.getEtat_avencement());
	                	 }
	                 }
	                 double s=0;
	                for(double d :values)
	                {
	                	s=s+d;
	                }
	                value=(double)s/values.size();
		      	}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return value;
	}

	public boolean DeposerDocument(String Titre, String Motcle, int IDprof, String path, String type) {
		Document doc = new Document();
			
		try {
			etudiant= new DAOEtudiant();
			document= new DAODocument();
			for(Document c: document.getAll())
			{
				if(c.getMot_cles().equals(Motcle) || c.getTitre().equals(Titre))
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

