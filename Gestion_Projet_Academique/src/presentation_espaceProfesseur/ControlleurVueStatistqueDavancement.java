package presentation_espaceProfesseur;

import metier.getionProfesseur.modelVueStatistqueDavancement;

public class ControlleurVueStatistqueDavancement {
	private VueStatistqueDavancement statistique;
	private modelVueStatistqueDavancement modelvueStatistqueDavancement;

	public ControlleurVueStatistqueDavancement(VueStatistqueDavancement statistique) {
		super();
		this.statistique = statistique;
		passage(statistique);
	}

	private void passage(VueStatistqueDavancement statistique2) {
	
		statistique.getButtonConsulterChq().addActionListener(e ->ConsulterById() );
		statistique.getButtonConsulterParType().addActionListener(e ->ConsulterParType() );
		statistique.getButtonCosulterTous().addActionListener(e ->CosulterTous());
	}

	private void CosulterTous() {
		modelvueStatistqueDavancement= new modelVueStatistqueDavancement();
		float value=modelvueStatistqueDavancement.getAvancementrous();
		statistique.getLabelAvncPorcentage3().setText(value+"%");
	}

	private void ConsulterParType() {
		modelvueStatistqueDavancement= new modelVueStatistqueDavancement();
		float value=modelvueStatistqueDavancement.getAvancementValueByType(statistique.getTypePjtcomboBox().getSelectedItem().toString());
		statistique.getLabelAvncPorcentage2().setText(value+"%");
	}

	private void ConsulterById() {
		
		modelvueStatistqueDavancement= new modelVueStatistqueDavancement();
		if(!statistique.getIdProjetTextField().getText().equals("") )
	
		 {
	        Double value=modelvueStatistqueDavancement.getAvancementValueByID(Integer.valueOf(statistique.getIdProjetTextField().getText()));
	        statistique.getLabelAvncPorcentage1().setText(value+"%");
		 }
	
	}

}
