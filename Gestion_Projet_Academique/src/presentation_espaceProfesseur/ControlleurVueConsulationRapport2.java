package presentation_espaceProfesseur;

import javax.swing.JOptionPane;

import metier.getionProfesseur.modelVueConsulationRapport2;
import metier.pojo.Etudiant;

public class ControlleurVueConsulationRapport2 {

	private VueConsulationRapport2 Vuerapport;
    private modelVueConsulationRapport2 modelvueConsulationRapport2;
	public ControlleurVueConsulationRapport2(VueConsulationRapport2 vuerapport) {
		super();
		Vuerapport = vuerapport;
		passage(vuerapport);
	}

	private void passage(VueConsulationRapport2 vuerapport) {

		vuerapport.getButtonConsulter().addActionListener(e -> consulterRapport());
		vuerapport.getValidebutton().addActionListener(e ->valide());
		
	}



	private void consulterRapport() {
		String path;
		modelvueConsulationRapport2= new modelVueConsulationRapport2();
		int index =Vuerapport.getEtudiantTable().getSelectedRow();
		if(index==-1)
			JOptionPane.showMessageDialog(null, "Selectionnez l'etudiant (e)");
		else
		{
			path=modelvueConsulationRapport2.checkRapport(Vuerapport.getEtudiantTable().getModel().getValueAt(index, 0).toString());
		    Vuerapport.getPath().setText(path);
		}

			
	
			
		
	}
	private void valide() {
		Vuerapport.setVisible(false);
	}
}
