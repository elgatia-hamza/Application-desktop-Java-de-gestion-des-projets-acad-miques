package metier.pojo;

public class Document {
	private int id_document;
	private String titre;
	private String mot_cles;
	private String type_document;
	private String path;
	private Integer id_professeur;
	private Integer id_etudiant;
	
	public Document() {
		super();
	}
	
	


	



	public String getPath() {
		return path;
	}








	public void setPath(String path) {
		this.path = path;
	}








	@Override
	public String toString() {
		return "Document [id_document=" + id_document + ", titre=" + titre + ", mot_cles=" + mot_cles
				+ ", type_document=" + type_document + ", path=" + path + ", id_professeur=" + id_professeur
				+ ", id_etudiant=" + id_etudiant + "]";
	}








	public int getId_document() {
		return id_document;
	}




	public void setId_document(int id_document) {
		this.id_document = id_document;
	}




	public String getTitre() {
		return titre;
	}




	public void setTitre(String titre) {
		this.titre = titre;
	}




	public String getMot_cles() {
		return mot_cles;
	}




	public void setMot_cles(String mot_cles) {
		this.mot_cles = mot_cles;
	}




	public String getType_document() {
		return type_document;
	}




	public void setType_document(String type_document) {
		this.type_document = type_document;
	}




	public Integer getId_professeur() {
		return id_professeur;
	}




	public void setId_professeur(Integer id_professeur) {
		this.id_professeur = id_professeur;
	}




	public Integer getId_etudiant() {
		return id_etudiant;
	}




	public void setId_etudiant(Integer id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
		
}
