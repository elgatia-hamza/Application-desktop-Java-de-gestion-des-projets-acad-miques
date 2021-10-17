package metier.pojo;

public class Administrateur {
	private int id_administrateur;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	
	public Administrateur() {
		super();
	}

	
	@Override
	public String toString() {
		return "Administrateur [id_administrateur=" + id_administrateur + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", login=" + login + ", password=" + password + "]";
	}


	public int getId_administrateur() {
		return id_administrateur;
	}

	public void setId_administrateur(int id_administrateur) {
		this.id_administrateur = id_administrateur;
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
