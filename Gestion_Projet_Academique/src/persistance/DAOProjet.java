package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Projet;


/**
 * @author Hamza
 *
 */


public class DAOProjet implements crud<Projet> {
	private Connection connect;
	
	public DAOProjet() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Projet projet) {
		Statement s;
		if (this.isExiste(projet))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO projet VALUES("
			+projet.getId_projet()+", \""
			+projet.getTheme_projet()+"\", \""
			+projet.getType()+"\", \""
			+projet.getCloture()+"\", \""
			+projet.getDuree()+"\","
			+projet.getEtat_avencement()+","
			+projet.getRapport()+", "
			+projet.getId_professeur()+", "
			+projet.getId_administrateur()
			+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Projet projet) {
		Statement s;
		if (!this.isExiste(projet))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM projet WHERE id_projet="+projet.getId_projet());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Projet projet) {
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM projet");
			while(r.next()) {
				if(r.getInt("id_projet")==projet.getId_projet())
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public Projet searchById(int id) {
		Statement s;
		ResultSet r=null;
		Projet p = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM projet");
			while(r.next()) {
				if(r.getInt("id_projet")==id) {
					p = new Projet();
					p.setId_projet(r.getInt("id_projet"));
					p.setTheme_projet(r.getString("theme_projet"));
					p.setType(r.getString("type"));
					p.setCloture(r.getString("cloture"));
					p.setDuree(r.getString("duree"));
					p.setEtat_avencement(r.getInt("etat_avencement"));
					p.setRapport(r.getInt("rapport"));
					p.setId_professeur(r.getInt("id_professeur"));
					p.setId_administrateur(r.getInt("id_administrateur"));
					return p;
				}	
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			return null;
		}
		return p;
	}

	@Override
	public ArrayList<Projet> getAll() {
		ArrayList<Projet> Array = new ArrayList<Projet>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM projet");
			while(r.next()) {
				Projet p = new Projet();
				p.setId_projet(r.getInt("id_projet"));
				p.setTheme_projet(r.getString("theme_projet"));
				p.setType(r.getString("type"));
				p.setCloture(r.getString("cloture"));
				p.setDuree(r.getString("duree"));
				p.setEtat_avencement(r.getInt("etat_avencement"));
				p.setRapport(r.getInt("rapport"));
				p.setId_professeur(r.getInt("id_professeur"));
				p.setId_administrateur(r.getInt("id_administrateur"));
				Array.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return Array;
	}

	@Override
	public boolean update(int id, Projet projet) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(projet) && id != projet.getId_projet())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE projet SET "+
					"id_projet="+projet.getId_projet()+
					", theme_projet=\""+projet.getTheme_projet() +"\""+
					", type=\""+projet.getType() +"\""+
					", cloture=\""+projet.getCloture() +"\""+
					", duree=\""+projet.getDuree() +"\""+
					", etat_avencement="+projet.getEtat_avencement()+
					", rapport="+projet.getRapport() +
					", id_professeur="+projet.getId_professeur() +
					", id_administrateur="+projet.getId_administrateur() +
					" WHERE id_projet="+id
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
