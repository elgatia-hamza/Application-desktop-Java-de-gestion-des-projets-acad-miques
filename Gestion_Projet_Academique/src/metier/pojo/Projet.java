package metier.pojo;

public class Projet {
	private int id_projet;
	private int id_professeur;
	private int id_administrateur;
	private String theme_projet;
	private String type;
	private String cloture;
	private String duree;
	private int etat_avencement;
	private int rapport;
	
	public Projet() {
		super();
	}

	
	@Override
	public String toString() {
		return "Projet [id_projet=" + id_projet + ", id_professeur=" + id_professeur + ", id_administrateur="
				+ id_administrateur + ", theme_projet=" + theme_projet + ", type=" + type + ", cloture=" + cloture
				+ ", duree=" + duree + ", etat_avencement=" + etat_avencement + ", rapport=" + rapport + "]";
	}


	public int getId_projet() {
		return id_projet;
	}

	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}

	public int getId_professeur() {
		return id_professeur;
	}

	public void setId_professeur(int id_professeur) {
		this.id_professeur = id_professeur;
	}

	public int getId_administrateur() {
		return id_administrateur;
	}

	public void setId_administrateur(int id_administrateur) {
		this.id_administrateur = id_administrateur;
	}

	public String getTheme_projet() {
		return theme_projet;
	}

	public void setTheme_projet(String theme_projet) {
		this.theme_projet = theme_projet;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCloture() {
		return cloture;
	}

	public void setCloture(String cloture) {
		this.cloture = cloture;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public int getEtat_avencement() {
		return etat_avencement;
	}

	public void setEtat_avencement(int etat_avencement) {
		this.etat_avencement = etat_avencement;
	}

	public int getRapport() {
		return rapport;
	}

	public void setRapport(int rapport) {
		this.rapport = rapport;
	}
	
}
