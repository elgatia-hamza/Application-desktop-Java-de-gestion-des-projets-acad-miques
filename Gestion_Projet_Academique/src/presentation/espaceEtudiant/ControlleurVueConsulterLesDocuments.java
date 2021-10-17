package presentation.espaceEtudiant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import metier.pojo.Etudiant;

public class ControlleurVueConsulterLesDocuments {
	private VueLaListeDesDocuments reteur;
	private VueConsulterLesDocumentsDeMonProjet consulte;
	public ControlleurVueConsulterLesDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ControlleurVueConsulterLesDocuments(VueLaListeDesDocuments reteur) {
		super();
		this.reteur = reteur;
	}
	public ControlleurVueConsulterLesDocuments(VueConsulterLesDocumentsDeMonProjet consulte) {
		super();
		this.consulte = consulte;
	}
	
	public void reteur(Etudiant etudiant) {
		this.reteur = new VueLaListeDesDocuments(etudiant);
		this.consulte.setVisible(false);
		
	}
	
}
