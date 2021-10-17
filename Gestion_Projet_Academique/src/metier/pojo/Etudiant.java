package metier.pojo;

public class Etudiant {
	private Integer id_etudiant;
	private Integer id_professeur;
	private Integer id_projet;
	private Integer id_filier;
	private String CNE;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	
	public Etudiant() {
		super();
	}

	
	@Override
	public String toString() {
		return "Etudiant [id_etudiant=" + id_etudiant + ", id_professeur=" + id_professeur + ", id_projet=" + id_projet
				+ ", id_filier=" + id_filier + ", CNE=" + CNE + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", login=" + login + ", password=" + password + "]";
	}


	public Integer getId_etudiant() {
		return id_etudiant;
	}


	public void setId_etudiant(Integer id_etudiant) {
		this.id_etudiant = id_etudiant;
	}


	public Integer getId_professeur() {
		return id_professeur;
	}


	public void setId_professeur(Integer id_professeur) {
		this.id_professeur = id_professeur;
	}


	public Integer getId_projet() {
		return id_projet;
	}


	public void setId_projet(Integer id_projet) {
		this.id_projet = id_projet;
	}


	public Integer getId_filier() {
		return id_filier;
	}


	public void setId_filier(Integer id_filier) {
		this.id_filier = id_filier;
	}


	public String getCNE() {
		return CNE;
	}


	public void setCNE(String cNE) {
		CNE = cNE;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
