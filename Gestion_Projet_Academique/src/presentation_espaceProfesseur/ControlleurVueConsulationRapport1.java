package presentation_espaceProfesseur;


import metier.gestion.ModeleTableEtudiantFORprofesseur;
import metier.getionProfesseur.modelVueConsulationRapport1;

public class ControlleurVueConsulationRapport1 {
	
	
	private VueConsulationRapport1 rapport;
	private modelVueConsulationRapport1 modelvueConsulationRapport1;
	private VueConsulationRapport2 rapport2;
	private ControlleurVueConsulationRapport2 controlleurVueConsulationRapport2;
	private int IDprof;

	public ControlleurVueConsulationRapport1(VueConsulationRapport1 rapport,int IDprof) {
		super();
		this.rapport = rapport;
		this.IDprof=IDprof;
		passage(rapport);
	}
	private void passage(VueConsulationRapport1 rapport) {
		rapport.getTrouverButton().addActionListener( e -> entrer());
		
	}
	private void entrer() {
		modelvueConsulationRapport1=new modelVueConsulationRapport1();	
		ModeleTableEtudiantFORprofesseur etudiants = modelvueConsulationRapport1.geJTableEtudiant(rapport.getFilierecomboBox().getSelectedItem().toString(),
				rapport.getTypecomboBox().getSelectedItem().toString(),this.IDprof);
		
		rapport2=new VueConsulationRapport2();
		rapport2.getEtudiantTable().setModel(etudiants);
		rapport2.setVisible(true);
		rapport.setVisible(false);
		controlleurVueConsulationRapport2 = new ControlleurVueConsulationRapport2(rapport2);
	}
	
}
