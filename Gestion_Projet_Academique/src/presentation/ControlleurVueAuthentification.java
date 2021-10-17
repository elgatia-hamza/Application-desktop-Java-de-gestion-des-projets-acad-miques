package presentation;

import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueBienvenu;
import presentation.espaceAdministrateur.VueBienvenu;
import presentation.espaceEtudiant.VueAccueil;
import presentation_espaceProfesseur.VueAcceuilProfesseur;

public class ControlleurVueAuthentification {
	private VuesAutentification vue_authentification;
	private VueBienvenu vue_bienvenu ;
	private VueAccueil vue_Accueil;
	private VueAcceuilProfesseur vueAcceuilProfesseur;
	
	public ControlleurVueAuthentification() {
		super();
	}
	
	
	public VuesAutentification getVue_authentification() {
		return vue_authentification;
	}



	public void setVue_authentification(VuesAutentification vue_authentification) {
		this.vue_authentification = vue_authentification;
	}



	public VueBienvenu getVue_bienvenu() {
		return vue_bienvenu;
	}



	public void setVue_bienvenu(VueBienvenu vue_bienvenu) {
		this.vue_bienvenu = vue_bienvenu;
	}

	public VueAccueil getVue_Accueil() {
		return vue_Accueil;
	}


	public void setVue_Accueil(VueAccueil vue_Accueil) {
		this.vue_Accueil = vue_Accueil;
	}




	public void executeVueBienvenuAdministrateur(ModeleVueBienvenu modele_bienvenu) {
		try {
			this.vue_bienvenu = new VueBienvenu(modele_bienvenu);
			this.vue_authentification.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeVueBienvenuEtudiant(ModeleVueAccueil modele_Accueil) {
		try {
			this.vue_Accueil = new VueAccueil(modele_Accueil);
			this.vue_authentification.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void executeVueAuthentification(){
		this.vue_authentification = new VuesAutentification();
	}
}
