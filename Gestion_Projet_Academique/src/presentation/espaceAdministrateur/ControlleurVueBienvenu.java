package presentation.espaceAdministrateur;

import metier.gestion.ModeleVueBienvenu;
import metier.gestion.ModeleVueDonneesEtudiant;
import metier.gestion.ModeleVueDonneesProfesseur;
import metier.gestion.ModeleVueDonneesProjets;

public class ControlleurVueBienvenu {
	private VueDonneesEtudiant vue_etudiant;
	private VueDonneesProfesseur vue_professeur;
	private VueDonneesProjets vue_projets;
	private VueBienvenu vue_bienvenu;
	
	public ControlleurVueBienvenu() {
		
	}

	public ControlleurVueBienvenu(VueDonneesEtudiant vue_etudiant) {
		super();
		this.vue_etudiant = vue_etudiant;
	}

	public ControlleurVueBienvenu(VueDonneesProfesseur vue_professeur) {
		super();
		this.vue_professeur = vue_professeur;
	}

	public ControlleurVueBienvenu(VueDonneesProjets vue_projets) {
		super();
		this.vue_projets = vue_projets;
	}
	
	public ControlleurVueBienvenu(VueBienvenu vue_bienvenu) {
		super();
		this.vue_bienvenu = vue_bienvenu;
	}
	
	
	public void executeVueDonneesEtudiant() {
		try {
			this.vue_etudiant = new VueDonneesEtudiant();
			this.vue_bienvenu.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeVueDonneesProfesseur() {
		try {
			this.vue_professeur = new VueDonneesProfesseur();
			this.vue_bienvenu.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeVueDonneesProjets(ModeleVueBienvenu modele) {
		try {
			this.vue_projets = new VueDonneesProjets(new ModeleVueDonneesProjets(modele.getAdministrateur()));
			this.vue_bienvenu.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
