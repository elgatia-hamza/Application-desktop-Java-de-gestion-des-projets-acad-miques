package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.pojo.Document;

/**
 * @author Hamza
 *
 */


public class DAODocument implements crud<Document>{
	private Connection connect;
	
	public DAODocument() throws ClassNotFoundException {
		super();
		connect = ConnexionBD.getInstance();
	}

	@Override
	public boolean add(Document document) {
		Statement s;
		if (this.isExiste(document)) 
			return false;

		try {
			s = connect.createStatement();
			s.executeUpdate("INSERT INTO document VALUES("
			+document.getId_document()+","+
			" \""+document.getTitre()+"\" ,"+
			" \""+document.getMot_cles()+"\" ,"
			+document.getId_professeur()+","
			+" \""+document.getPath()+"\" ,"
			+document.getId_etudiant() + ","
			+" \""+document.getType_document()+"\" "
			+")");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Document document) {
		Statement s;
		if (!this.isExiste(document))
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("DELETE FROM document WHERE id_document="+document.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isExiste(Document document) {
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM document");
			while(r.next()) {
				if(r.getInt("id_document")==document.getId_document()) 
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
	public Document searchById(int id) {
		Statement s;
		ResultSet r=null;
		Document d = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM document");
			while(r.next()) {
				if(r.getInt("id_document")==id) {
					d = new Document();
					d.setId_document(r.getInt("id_document"));
					d.setTitre(r.getString("titre"));
					d.setMot_cles(r.getString("mot_cles"));
					d.setId_professeur(r.getInt("id_professeur"));
					d.setPath(r.getString("path"));
					d.setId_etudiant(r.getInt("id_etudiant"));
					d.setType_document(r.getString("type_document"));
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
	public ArrayList<Document> getAll() {
		ArrayList<Document> Array = new ArrayList<Document>();
		Statement s;
		ResultSet r = null;
		try {
			s = connect.createStatement();
			r= s.executeQuery("SELECT * FROM document");
			while(r.next()) {
				Document d = new Document();
				d.setId_document(r.getInt("id_document"));
				d.setTitre(r.getString("titre"));
				d.setMot_cles(r.getString("mot_cles"));
				d.setId_professeur(r.getInt("id_professeur"));
				d.setPath(r.getString("path"));
				d.setId_etudiant(r.getInt("id_etudiant"));
				d.setType_document(r.getString("type_document"));
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
	public boolean update(int id, Document document) {
		Statement s;
		if (this.searchById(id)==null)
			return false;
		if (this.isExiste(document) && id != document.getId_document())
			return false;
		
		try {
			s = connect.createStatement();
			s.executeUpdate("UPDATE document SET "+
					"id_document="+document.getId_document()+
					", titre=\""+document.getTitre() +"\""+
					", mot_cles=\""+document.getMot_cles() +"\""+
					", id_professeur="+document.getId_professeur()+
					", path=\""+document.getPath()+ "\""+ 
					", id_etudiant="+ document.getId_etudiant() +
					", type_document="+" \""+document.getType_document()+"\""
					+" WHERE id_document="+id
					);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<Document> searchById_etudiant(int id_etudiant){
		ArrayList<Document> listDocument = new ArrayList<Document>();
		ArrayList<Document> all = getAll();
		for (Document document : all) {
			if(document.getId_etudiant().equals(id_etudiant)) {
				listDocument.add(document);
			}
		}
		return listDocument;
	}
	
	public ArrayList<Document> searchDocument(int id_etudiant,int id_professeur){
		ArrayList<Document> listDocument = new ArrayList<Document>();
		ArrayList<Document> all = getAll();
		for (Document document : all) {
			if(document.getId_etudiant().equals(id_etudiant) && document.getId_professeur().equals(id_professeur)) {
				listDocument.add(document);
			}
		}
		return listDocument;
	}
	
	
}
