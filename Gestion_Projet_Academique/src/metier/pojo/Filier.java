package metier.pojo;

public class Filier {
	private int id_filier;
	private String nom_filier;
	private int niveau;
	private int id_departement;
	
	public Filier() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Filier [id_filier=" + id_filier + ", nom_filier=" + nom_filier + ", niveau=" + niveau
				+ ", id_departement=" + id_departement + "]";
	}


	public int getId_filier() {
		return id_filier;
	}

	public void setId_filier(int id_filier) {
		this.id_filier = id_filier;
	}

	public String getNom_filier() {
		return nom_filier;
	}

	public void setNom_filier(String nom_filier) {
		this.nom_filier = nom_filier;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getId_departement() {
		return id_departement;
	}

	public void setId_departement(int id_departement) {
		this.id_departement = id_departement;
	}
}
