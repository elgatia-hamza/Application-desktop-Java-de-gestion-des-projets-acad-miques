package presentation_espaceProfesseur;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableEtudiantFORprofesseur;
import metier.getionProfesseur.modelVueconsulterDocLivrable1;

public class ControlleurVueconsulterDocLivrable1 {

	private VueconsulterDocLivrable1 livrableDOC;
	private VueconsulterDocLivrable2 livrableDOC2;
	private modelVueconsulterDocLivrable1 modelvueconsulterDocLivrable1;
	private ControlleurVueconsulterDocLivrable2 controlleurVueconsulterDocLivrable2;
	private int IDprof;
	public ControlleurVueconsulterDocLivrable1(VueconsulterDocLivrable1 livrableDOC,int IDprof) {
		super();
		this.livrableDOC = livrableDOC;
		this.IDprof=IDprof;
		passage(livrableDOC);
	}
	private void passage(VueconsulterDocLivrable1 livrableDOC) {
		livrableDOC.getTrouverButton().addActionListener( e -> entrer());
		
	}
	private void entrer() {
		modelvueconsulterDocLivrable1=new modelVueconsulterDocLivrable1();	
		ModeleTableEtudiantFORprofesseur etudiants = modelvueconsulterDocLivrable1.geJTableEtudiant(livrableDOC.getFilierecomboBox().getSelectedItem().toString(),
				livrableDOC.getTypecomboBox().getSelectedItem().toString(),this.IDprof);

		livrableDOC2=new VueconsulterDocLivrable2();
	   livrableDOC2.getTableEtudiant().setModel(etudiants);
		livrableDOC2.setVisible(true);
		livrableDOC.setVisible(false);
		controlleurVueconsulterDocLivrable2=new ControlleurVueconsulterDocLivrable2(livrableDOC2);
	}
	
	 
	
}
