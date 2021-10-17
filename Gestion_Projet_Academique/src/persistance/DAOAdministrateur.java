package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Administrateur;


/**
 * @author Hamza
 *
 */


public class DAOAdministrateur implements crud<Administrateur>{
	private Connection connect;
	
	public DAOAdministrateur() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Administrateur administrateur) {
		Statement s;
		if (this.isExiste(administrateur))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO administrateur VALUES("
			+administrateur.getId_administrateur()+", \""
			+administrateur.getNom()+"\", \""
			+administrateur.getPrenom()+"\", \""
			+administrateur.getEmail()+"\", \""
			+administrateur.getLogin()+"\", \""
			+administrateur.getPassword()+"\""
			+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Administrateur administrateur) {
		Statement s;
		if (!this.isExiste(administrateur))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM administrateur WHERE id_administrateur="+administrateur.getId_administrateur());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Administrateur administrateur) {
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM administrateur");
			while(r.next()) {
				if(r.getInt("id_administrateur")==administrateur.getId_administrateur())
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
	public Administrateur searchById(int id) {
		Statement s;
		ResultSet r=null;
		Administrateur a = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM administrateur");
			while(r.next()) {
				if(r.getInt("id_administrateur")==id) {
					a = new Administrateur();
					a.setId_administrateur(r.getInt("id_administrateur"));
					a.setNom(r.getString("nom"));
					a.setPrenom(r.getString("prenom"));
					a.setEmail(r.getString("email"));
					a.setLogin(r.getString("login"));
					a.setPassword(r.getString("password"));
					return a;
				}	
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			return null;
		}
		return a;
	}

	@Override
	public ArrayList<Administrateur> getAll() {
		ArrayList<Administrateur> Array = new ArrayList<Administrateur>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM administrateur");
			while(r.next()) {
				Administrateur a = new Administrateur();
				a.setId_administrateur(r.getInt("id_administrateur"));
				a.setNom(r.getString("nom"));
				a.setPrenom(r.getString("prenom"));
				a.setEmail(r.getString("email"));
				a.setLogin(r.getString("login"));
				a.setPassword(r.getString("password"));
				Array.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return Array;
	}

	@Override
	public boolean update(int id, Administrateur administrateur) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(administrateur) && id != administrateur.getId_administrateur())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE administrateur SET "+
					"id_administrateur="+administrateur.getId_administrateur()+
					", nom=\""+administrateur.getNom() +"\""+
					", prenom=\""+administrateur.getPrenom() +"\""+
					", email=\""+administrateur.getEmail() +"\""+
					", login=\""+administrateur.getLogin() +"\""+
					", password=\""+administrateur.getPassword() +"\""+
					" WHERE id_administrateur="+id
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
