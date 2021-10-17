package presentation.espaceAdministrateur;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableProfesseur;
import metier.pojo.Etudiant;
import metier.pojo.Professeur;

public class ControlleurVueDonneesProfesseur {
	private VueDonneesProfesseur vueDonneesProfesseur;
	private VueNouvelleDonneeProfesseur vueNouvelleDonneeProfesseur;

	public ControlleurVueDonneesProfesseur() {
		super();
	}

	public ControlleurVueDonneesProfesseur(VueDonneesProfesseur vueDonneesProfesseur) {
		super();
		this.vueDonneesProfesseur = vueDonneesProfesseur;
	}

	public ControlleurVueDonneesProfesseur(VueNouvelleDonneeProfesseur vueNouvelleDonneeProfesseur) {
		super();
		this.vueNouvelleDonneeProfesseur = vueNouvelleDonneeProfesseur;
	}
	
	public void executeVueProfesseur() {
		
	}
	
	public void executeVueNouvelleDonneeProfesseur(Professeur professeur, ModeleTableProfesseur tableProfesseur) {
		try {
			vueNouvelleDonneeProfesseur = new VueNouvelleDonneeProfesseur(professeur,tableProfesseur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
