package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Filier;


/**
 * @author Hamza
 *
 */


public class DAOFilier implements crud<Filier>{
	private Connection connect;
	
	public DAOFilier() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Filier filier) {
		Statement s;
		if (this.isExiste(filier))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO filier VALUES("
			+filier.getId_filier()+","+
			" \""+filier.getNom_filier()+"\" ,"
			+filier.getNiveau()+","
			+filier.getId_departement()
			+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Filier filier) {
		Statement s;
		if (!this.isExiste(filier))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM filier WHERE id_filier="+filier.getId_filier());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Filier filier) {
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM filier");
			while(r.next()) {
				if(r.getInt("id_filier")==filier.getId_filier())
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
	public Filier searchById(int id) {
		Statement s;
		ResultSet r=null;
		Filier f = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM filier");
			while(r.next()) {
				if(r.getInt("id_filier")==id) {
					f = new Filier();
					f.setId_filier(r.getInt("id_filier"));
					f.setNom_filier(r.getString("nom_filier"));
					f.setNiveau(r.getInt("niveau"));
					f.setId_departement(r.getInt("id_departement"));
					return f;
				}	
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			return null;
		}
		return f;
	}

	@Override
	public ArrayList<Filier> getAll() {
		ArrayList<Filier> Array = new ArrayList<Filier>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM filier");
			while(r.next()) {
				Filier f = new Filier();
				f.setId_filier(r.getInt("id_filier"));
				f.setNom_filier(r.getString("nom_filier"));
				f.setNiveau(r.getInt("niveau"));
				f.setId_departement(r.getInt("id_departement"));
				Array.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return Array;
	}

	@Override
	public boolean update(int id, Filier filier) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(filier) && id != filier.getId_filier())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE filier SET "+
					"id_filier="+filier.getId_filier()+
					", nom_filier=\""+filier.getNom_filier() +"\""+
					", niveau="+filier.getNiveau()+
					", id_departement="+filier.getId_departement()+
					" WHERE id_filier="+id
					);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

}
