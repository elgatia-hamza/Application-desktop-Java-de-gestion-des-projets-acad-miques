package metier.pojo;

public class Departement {
	private int id_departement;
	private String nom_departement;
	
	public Departement() {
		super();
	}

	
	@Override
	public String toString() {
		return "Departement [id_departement=" + id_departement + ", nom_departement=" + nom_departement + "]";
	}


	public int getId_departement() {
		return id_departement;
	}

	public void setId_departement(int id_departement) {
		this.id_departement = id_departement;
	}

	public String getNom_departement() {
		return nom_departement;
	}

	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
	}
}
