package metier.pojo;

public class Professeur {
	private Integer id_professeur;
	private Integer id_departement;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	private String domaine_recherche;
	
	public Professeur() {
		super();
	}

	
	@Override
	public String toString() {
		return "Professeur [id_professeur=" + id_professeur + ", id_departement=" + id_departement + ", nom=" + nom
				+ ", prenom=" + prenom + ", email=" + email + ", login=" + login + ", password=" + password
				+ ", domaine_recherche=" + domaine_recherche + "]";
	}

	public Integer getId_professeur() {
		return id_professeur;
	}


	public void setId_professeur(Integer id_professeur) {
		this.id_professeur = id_professeur;
	}


	public Integer getId_departement() {
		return id_departement;
	}


	public void setId_departement(Integer id_departement) {
		this.id_departement = id_departement;
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

	public String getDomaine_recherche() {
		return domaine_recherche;
	}

	public void setDomaine_recherche(String domaine_recherche) {
		this.domaine_recherche = domaine_recherche;
	}
}
