package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Professeur;


/**
 * @author Hamza
 *
 */


public class DAOProfesseur implements crud<Professeur>{
	private Connection connect;
	
	public DAOProfesseur() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Professeur professeur) {
		Statement s;
		if (this.isExiste(professeur))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO professeur VALUES("
			+professeur.getId_professeur()+", \""
			+professeur.getNom()+"\", \""
			+professeur.getPrenom()+"\", \""
			+professeur.getEmail()+"\", \""
			+professeur.getLogin()+"\", \""
			+professeur.getPassword()+"\",\""
			+professeur.getDomaine_recherche()+"\","
			+professeur.getId_departement()
			+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Professeur professeur) {
		Statement s;
		if (!this.isExiste(professeur))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM professeur WHERE id_professeur="+professeur.getId_professeur());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Professeur professeur) {
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM professeur");
			while(r.next()) {
				if(r.getInt("id_professeur")==professeur.getId_professeur())
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
	public Professeur searchById(int id) {
		Statement s;
		ResultSet r=null;
		Professeur p = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM professeur");
			while(r.next()) {
				if(r.getInt("id_professeur")==id) {
					p = new Professeur();
					p.setId_professeur(r.getInt("id_professeur"));
					p.setNom(r.getString("nom"));
					p.setPrenom(r.getString("prenom"));
					p.setEmail(r.getString("email"));
					p.setLogin(r.getString("login"));
					p.setPassword(r.getString("password"));
					p.setDomaine_recherche(r.getString("domaine_recherche"));
					p.setId_departement(r.getInt("id_departement"));
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
	public ArrayList<Professeur> getAll() {
		ArrayList<Professeur> Array = new ArrayList<Professeur>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM professeur");
			while(r.next()) {
				Professeur p = new Professeur();
				p.setId_professeur(r.getInt("id_professeur"));
				p.setNom(r.getString("nom"));
				p.setPrenom(r.getString("prenom"));
				p.setEmail(r.getString("email"));
				p.setLogin(r.getString("login"));
				p.setPassword(r.getString("password"));
				p.setDomaine_recherche(r.getString("domaine_recherche"));
				p.setId_departement(r.getInt("id_departement"));
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
	public boolean update(int id, Professeur professeur) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(professeur) && id != professeur.getId_professeur())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE professeur SET "+
					"id_professeur="+professeur.getId_professeur()+
					", nom=\""+professeur.getNom() +"\""+
					", prenom=\""+professeur.getPrenom() +"\""+
					", email=\""+professeur.getEmail() +"\""+
					", login=\""+professeur.getLogin() +"\""+
					", password=\""+professeur.getPassword() +"\""+
					", domaine_recherche=\""+professeur.getDomaine_recherche() +"\""+
					", id_departement="+professeur.getId_departement() +
					" WHERE id_professeur="+id
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
