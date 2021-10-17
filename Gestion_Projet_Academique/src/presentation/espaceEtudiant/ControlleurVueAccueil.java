package presentation.espaceEtudiant;

import metier.gestion.ModeleVueAccueil;
import metier.pojo.Etudiant;


public class ControlleurVueAccueil {
	private VueMesRendezVous vue_RendezVous;
	private VueLaListeDesDocuments vue_LiteDesDocuments;
	private VueAccueil vue_Accueil;
	
	public ControlleurVueAccueil() {
		super();
		
	}
	public ControlleurVueAccueil(VueMesRendezVous vue_RendezVous) {
		super();
		this.vue_RendezVous = vue_RendezVous;
	}
	public ControlleurVueAccueil(VueLaListeDesDocuments vue_LiteDesDocuments) {
		super();
		this.vue_LiteDesDocuments = vue_LiteDesDocuments;
	}
	
	public ControlleurVueAccueil(VueAccueil vue_Accueil) {
		super();
		this.vue_Accueil = vue_Accueil;
	}
	public void executeVueMesRendezVous(Etudiant etudiant) {
		try {
			this.vue_RendezVous = new VueMesRendezVous(etudiant);
			this.vue_Accueil.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeVueLaListeDesDocuments(Etudiant etudiant) {
		try {
			this.vue_LiteDesDocuments = new VueLaListeDesDocuments(etudiant);
			this.vue_Accueil.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
