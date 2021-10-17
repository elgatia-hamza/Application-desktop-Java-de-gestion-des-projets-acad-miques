package metier.gestion;

import metier.pojo.Etudiant;

public class ModeleVueAccueil {
	private Etudiant etudiant;

	public ModeleVueAccueil() {
		super();
		
	}

	public ModeleVueAccueil(Etudiant etudiant) {
		super();
		this.etudiant = etudiant;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public String getEtudiantNom() {
		if(etudiant == null)
			return null;
		return  etudiant.getNom();
	}
	
}
