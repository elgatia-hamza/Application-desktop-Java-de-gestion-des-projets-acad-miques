package presentation.espaceEtudiant;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueBienvenu;
import metier.gestion.ModeleVueDeposerUnDocument;
import metier.pojo.Etudiant;



public class ControlleurVueMesRendezVous {
	private VueAccueil vue_Accueil;
	private VueMesRendezVous vueMesRendezVous;
	
	

	
	public ControlleurVueMesRendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ControlleurVueMesRendezVous(VueAccueil vue_Accueil) {
		super();
		this.vue_Accueil = vue_Accueil;
	}




	public ControlleurVueMesRendezVous(VueMesRendezVous vueMesRendezVous) {
		super();
		this.vueMesRendezVous = vueMesRendezVous;
	}




	public void executeVueAccueil(ModeleVueAccueil modele) {
		try {
			this.vue_Accueil = new VueAccueil(modele);
			this.vueMesRendezVous.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
