package presentation.espaceEtudiant;

import metier.pojo.Etudiant;

public class ControlleurVueDeposerUnDocument {
	private VueLaListeDesDocuments reteur;
	private VueDeposerUnDocument deposer;
	 

	public ControlleurVueDeposerUnDocument(VueDeposerUnDocument deposer) {
		super();
		this.deposer = deposer;
	}

	public ControlleurVueDeposerUnDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ControlleurVueDeposerUnDocument(VueLaListeDesDocuments reteur) {
		super();
		this.reteur = reteur;
	}

	public void reteur(Etudiant etudiant) {
		this.reteur = new VueLaListeDesDocuments(etudiant);
		this.deposer.setVisible(false);
		
	}
	
	
}
