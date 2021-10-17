package metier.getionProfesseur;

import java.util.ArrayList;

import metier.pojo.Projet;
import persistance.DAOAdministrateur;
import persistance.DAODocument;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;
import persistance.DAOProjet;

public class modelVueStatistqueDavancement {

	
	private DAOProjet projet;
	
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
	
	public Float getAvancementValueByType(String type) {
		float value = 0;
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
	                 int s=0;
	                for(int d :values)
	                {
	                	s=s+d;
	                }
	                if(values.size()!=0)
	                value=((float)s)/values.size();
		      	}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return value;
	}
	
	
	public Float getAvancementrous() {
		float value = 0;
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
	                 int s=0;
	                for(int d :values)
	                {
	                	s=s+d;
	                }
	                value=(float)s/values.size();
		      	}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return value;
	}
}
