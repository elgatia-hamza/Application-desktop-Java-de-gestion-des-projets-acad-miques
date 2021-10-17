package presentation_espaceProfesseur;


import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableEtudiantFORprofesseur;
import metier.gestion.ModeleTableProjet;
import metier.getionProfesseur.ModelVueAcceuilProfesseur;

public class ControlleurVueAcceuilProfesseur {
	private VueAcceuilProfesseur vueAccueil;
	private VueconsulterDocLivrable1 livrableDOC;
	private ControlleurVueconsulterDocLivrable1 controlleurVueconsulterDocLivrable1;
	private ControlleurVueConsulationRapport1 controlleurVueConsulationRapport1;
    private VueConsulationRapport1 rapport;
    private VueDeposerDoc depotDoc;
    private ControlleurVueDeposerDoc controlleurVueDeposerDoc;
    private VueStatistqueDavancement statistque;
    private ControlleurVueStatistqueDavancement controlleurVueStatistqueDavancement;
    private ModelVueAcceuilProfesseur modelVueAcceuilProfesseur;
    private VuesAuthentification Authentification ;
    private int IDprof;
	public ControlleurVueAcceuilProfesseur(VueAcceuilProfesseur vueAccueil,int IDprof) {
		super();
		this.vueAccueil = vueAccueil;
		this.IDprof=IDprof;
		choisir(vueAccueil);
	}
    
	public void choisir(VueAcceuilProfesseur vueAccueil)
	{
		vueAccueil.getButtonconsultDocLivrable().addActionListener( e -> livrable());
		vueAccueil.getButtonConsultRpprt().addActionListener(e -> rapport());
		vueAccueil.getButtonDeposeDoc().addActionListener(e -> deposerDoc());
		vueAccueil.getButtonStatistiqueAvn().addActionListener(e -> Statistique());
	
	}
	
	
	
	
	private void Retour() {
		Authentification= new VuesAuthentification();
		Authentification.setVisible(true);
		vueAccueil.setVisible(false);

	}

	private void Statistique() {
		statistque = new VueStatistqueDavancement();
		modelVueAcceuilProfesseur= new ModelVueAcceuilProfesseur();
		ModeleTableEtudiantFORprofesseur etudiant=modelVueAcceuilProfesseur.getEtudiantTable(this.IDprof);
		ModeleTableProjet  projet=modelVueAcceuilProfesseur.getProjetTable(this.IDprof);
		statistque.getTableEtudiant().setModel(etudiant);
	    statistque.getTableProjet().setModel(projet);;
		statistque.setVisible(true);
		controlleurVueStatistqueDavancement= new ControlleurVueStatistqueDavancement(statistque);
		vueAccueil.setVisible(false);
	}

	private void deposerDoc() {
		depotDoc = new VueDeposerDoc();
		depotDoc.setVisible(true);
		controlleurVueDeposerDoc = new ControlleurVueDeposerDoc(depotDoc,this.IDprof);
		vueAccueil.setVisible(false);

	}

	private void rapport() {
		rapport = new VueConsulationRapport1();
		rapport.setVisible(true);
		controlleurVueConsulationRapport1  = new ControlleurVueConsulationRapport1(rapport,this.IDprof);
		vueAccueil.setVisible(false);
	}

	private void livrable() {
		livrableDOC = new VueconsulterDocLivrable1();
		livrableDOC.setVisible(true);
		controlleurVueconsulterDocLivrable1 = new ControlleurVueconsulterDocLivrable1(livrableDOC,this.IDprof);
		vueAccueil.setVisible(false);
	}


	
	
	

}
