package presentation.espaceAdministrateur;

import metier.gestion.ModeleVueDonneesProjets;

public class ControlleurEditProjet {
	private VueNouvelleDonneeProjet vueNouvelleDonneeProjet;
	private VueEditProjet vueEditProjet;

	public ControlleurEditProjet() {
		super();
	}

	public ControlleurEditProjet(VueEditProjet vueEditProjet) {
		super();
		this.vueEditProjet = vueEditProjet;
	}
	
	public void exercuteVuNouvelleDonneeProjet(ModeleVueDonneesProjets modele) {
		try {
			vueNouvelleDonneeProjet = new VueNouvelleDonneeProjet(modele);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
