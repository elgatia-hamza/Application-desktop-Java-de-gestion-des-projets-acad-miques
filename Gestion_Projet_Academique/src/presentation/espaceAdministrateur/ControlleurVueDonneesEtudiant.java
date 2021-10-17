package presentation.espaceAdministrateur;

import metier.gestion.ModeleTableEtudiant;
import metier.pojo.Etudiant;

public class ControlleurVueDonneesEtudiant {
	private VueDonneesEtudiant vueEtudiant;
	private VueNouvelleDonneeEtudiant vueNouvelleDonneeEtudiant;

	public ControlleurVueDonneesEtudiant() {
		
	}

	public ControlleurVueDonneesEtudiant(VueDonneesEtudiant vueEtudiant) {
		super();
		this.vueEtudiant = vueEtudiant;
	}

	public ControlleurVueDonneesEtudiant(VueNouvelleDonneeEtudiant vueNouvelleDonneeEtudiant) {
		super();
		this.vueNouvelleDonneeEtudiant = vueNouvelleDonneeEtudiant;
	}
	
	public void executeVueEtudiant() {
		
	}
	
	public void executeVueNouvelleDonneeEtudiant(Etudiant etudiant, ModeleTableEtudiant tableEtudiant) {
		try {
			vueNouvelleDonneeEtudiant = new VueNouvelleDonneeEtudiant(etudiant,tableEtudiant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
