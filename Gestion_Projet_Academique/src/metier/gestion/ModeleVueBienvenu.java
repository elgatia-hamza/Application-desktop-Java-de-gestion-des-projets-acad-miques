package metier.gestion;

import metier.pojo.Administrateur;

public class ModeleVueBienvenu {
	private Administrateur administrateur;
	
	public ModeleVueBienvenu() {
		super();
	}
	
	public ModeleVueBienvenu(Administrateur administrateur) {
		super();
		this.administrateur = administrateur;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}
	
	public String getAdministrateurNom() {
		if(administrateur == null)
			return null;
		return  administrateur.getNom();
	}
	
}
