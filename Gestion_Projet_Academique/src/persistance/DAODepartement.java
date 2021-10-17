package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Departement;


/**
 * @author Hamza
 *
 */


public class DAODepartement implements crud<Departement>{
	private Connection connect;
	
	public DAODepartement() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Departement departement) {
		Statement s;
		if (this.isExiste(departement))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO departement VALUES("
			+departement.getId_departement()+","+
			" \""+departement.getNom_departement()+"\""
			+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Departement departement) {
		Statement s;
		if (!this.isExiste(departement))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM departement WHERE id_departement="+departement.getId_departement());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Departement departement) {
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM departement");
			while(r.next()) {
				if(r.getInt("id_departement")==departement.getId_departement())
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
	public Departement searchById(int id) {
		Statement s;
		ResultSet r=null;
		Departement d = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM departement");
			while(r.next()) {
				if(r.getInt("id_departement")==id) {
					d = new Departement();
					d.setId_departement(r.getInt("id_departement"));
					d.setNom_departement(r.getString("nom_departement"));
					return d;
				}	
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			return null;
		}
		return d;
	}

	@Override
	public ArrayList<Departement> getAll() {
		ArrayList<Departement> Array = new ArrayList<Departement>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM departement");
			while(r.next()) {
				Departement d = new Departement();
				d.setId_departement(r.getInt("id_departement"));
				d.setNom_departement(r.getString("nom_departement"));
				Array.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return Array;
	}

	@Override
	public boolean update(int id, Departement departement) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(departement) && id != departement.getId_departement())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE departement SET "+
					"id_departement="+departement.getId_departement()+
					", nom_departement=\""+departement.getNom_departement() +"\""+
					" WHERE id_departement="+id
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
