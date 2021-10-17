package presentation.espaceEtudiant;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueBienvenu;
import metier.gestion.ModeleVueDeposerUnDocument;
import metier.pojo.Etudiant;

public class ControlleurVueLaListeDesDocuments {
	private VueDeposerUnDocument vue_Deposer;
	private VueConsulterLesDocumentsDeMonProjet vue_Consulter;
	private VueLaListeDesDocuments vue_ListeDesDocuments;
	private VueAccueil vue_Accueil;
	
	public ControlleurVueLaListeDesDocuments() {
		super();
	}
	public ControlleurVueLaListeDesDocuments(VueDeposerUnDocument vue_Deposer) {
		super();
		this.vue_Deposer = vue_Deposer;
	}
	public ControlleurVueLaListeDesDocuments(VueConsulterLesDocumentsDeMonProjet vue_Consulter) {
		super();
		this.vue_Consulter = vue_Consulter;
	}
	public ControlleurVueLaListeDesDocuments(VueLaListeDesDocuments vue_LiteDesDocuments) {
		super();
		this.vue_ListeDesDocuments = vue_LiteDesDocuments;
	}
	public ControlleurVueLaListeDesDocuments(VueAccueil vue_Accueil) {
		super();
		this.vue_Accueil = vue_Accueil;
	}
	
	public void executeVueDeposerUnDocument(ModeleVueDeposerUnDocument modele1) {
		try {
			this.vue_Deposer = new VueDeposerUnDocument(modele1);
			this.vue_ListeDesDocuments.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void executeVueConsulterLesDocumentsDeMonProjet(Etudiant etudiant) {
		try {
			this.vue_Consulter = new VueConsulterLesDocumentsDeMonProjet(etudiant);
			this.vue_ListeDesDocuments.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void executeVueAccueil(ModeleVueAccueil modele) {
		try {
			this.vue_Accueil = new VueAccueil(modele);
			this.vue_ListeDesDocuments.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
