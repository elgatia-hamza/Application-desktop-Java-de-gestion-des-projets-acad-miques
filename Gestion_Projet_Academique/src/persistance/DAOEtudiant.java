package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Etudiant;


/**
 * @author Hamza
 *
 */


public class DAOEtudiant implements crud<Etudiant>{
	private Connection connect;
	
	public DAOEtudiant() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Etudiant etudiant) {
		Statement s;
		if (this.isExiste(etudiant))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO etudiant VALUES("
			+etudiant.getId_etudiant()+", \""
			+etudiant.getCNE()+"\", \""
			+etudiant.getNom()+"\", \""
			+etudiant.getPrenom()+"\", \""
			+etudiant.getEmail()+"\", \""
			+etudiant.getLogin()+"\", \""
			+etudiant.getPassword()+"\","
			+etudiant.getId_filier()+", "
			+etudiant.getId_professeur()+", "
			+etudiant.getId_projet()
			+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Etudiant etudiant) {
		Statement s;
		if (!this.isExiste(etudiant))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM etudiant WHERE id_etudiant="+etudiant.getId_etudiant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM etudiant");
			while(r.next()) {
				if(r.getInt("id_etudiant")==etudiant.getId_etudiant())
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
	public Etudiant searchById(int id) {
		Statement s;
		ResultSet r=null;
		Etudiant e = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM etudiant");
			while(r.next()) {
				if(r.getInt("id_etudiant")==id) {
					e = new Etudiant();
					e.setId_etudiant(r.getInt("id_etudiant"));
					e.setCNE(r.getString("CNE"));
					e.setNom(r.getString("nom"));
					e.setPrenom(r.getString("prenom"));
					e.setEmail(r.getString("email"));
					e.setLogin(r.getString("login"));
					e.setPassword(r.getString("password"));
					e.setId_filier(r.getInt("id_filier"));
					e.setId_professeur(r.getInt("id_professeur"));
					e.setId_projet(r.getInt("id_projet"));
					return e;
				}	
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			return null;
		}
		return e;
	}

	@Override
	public ArrayList<Etudiant> getAll() {
		ArrayList<Etudiant> Array = new ArrayList<Etudiant>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM etudiant");
			while(r.next()) {
				Etudiant e = new Etudiant();
				e.setId_etudiant(r.getInt("id_etudiant"));
				e.setCNE(r.getString("CNE"));
				e.setNom(r.getString("nom"));
				e.setPrenom(r.getString("prenom"));
				e.setEmail(r.getString("email"));
				e.setLogin(r.getString("login"));
				e.setPassword(r.getString("password"));
				e.setId_filier(r.getInt("id_filier"));
				e.setId_professeur(r.getInt("id_professeur"));
				e.setId_projet(r.getInt("id_projet"));
				Array.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return Array;
	}

	@Override
	public boolean update(int id, Etudiant etudiant) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(etudiant) && id != etudiant.getId_etudiant())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE etudiant SET "+
					"id_etudiant="+etudiant.getId_etudiant()+
					", CNE=\""+etudiant.getCNE() +"\""+
					", nom=\""+etudiant.getNom() +"\""+
					", prenom=\""+etudiant.getPrenom() +"\""+
					", email=\""+etudiant.getEmail() +"\""+
					", login=\""+etudiant.getLogin() +"\""+
					", password=\""+etudiant.getPassword() +"\""+
					", id_filier="+etudiant.getId_filier() +
					", id_professeur="+etudiant.getId_professeur() +
					", id_projet="+etudiant.getId_projet() +
					" WHERE id_etudiant="+id
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public ArrayList<Etudiant> getEtdiantByTypeFililere(String string, String string2) {
		Statement s=null;
		ResultSet r = null;
		ArrayList<Etudiant> ArrayETD = new ArrayList<Etudiant>();
		
		try {
			s = connect.createStatement();
			r=s.executeQuery("SELECT * FROM `etudiant`"
					+ " WHERE id_filier = any(select id_filier from `filier` where nom_filier =\""+string+"\")"
					+ " and id_projet= any(select id_projet from `projet` where type=\""+string2+"\")");
			
			while(r.next()) {
				Etudiant e = new Etudiant();
				e.setId_etudiant(r.getInt("id_etudiant"));
				e.setCNE(r.getString("CNE"));
				e.setNom(r.getString("nom"));
				e.setPrenom(r.getString("prenom"));
				e.setEmail(r.getString("email"));
				e.setLogin(r.getString("login"));
				e.setPassword(r.getString("password"));
				e.setId_filier(r.getInt("id_filier"));
				e.setId_professeur(r.getInt("id_professeur"));
				e.setId_projet(r.getInt("id_projet"));
				ArrayETD.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ArrayETD;
	}
}
