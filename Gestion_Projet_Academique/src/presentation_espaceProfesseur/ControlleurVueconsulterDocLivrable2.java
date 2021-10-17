package presentation_espaceProfesseur;


import javax.swing.JOptionPane;

import metier.getionProfesseur.modelVueconsulterDocLivrable2;

public class ControlleurVueconsulterDocLivrable2 {
	private VueconsulterDocLivrable2 livrableDOC2;
	private modelVueconsulterDocLivrable2 modelvueconsulterDocLivrable2;

	public ControlleurVueconsulterDocLivrable2(VueconsulterDocLivrable2 livrableDOC2) {
		super();
		this.livrableDOC2 = livrableDOC2;
		passage(livrableDOC2);
	}

	private void passage(VueconsulterDocLivrable2 livrableDOC2) {
		
		livrableDOC2.getButtonConsulterDoc().addActionListener(e-> consulterLivrable());
		livrableDOC2.getValideButton().addActionListener(e-> valider());
	}

	private void valider() {
		JOptionPane.showMessageDialog(null, "vous allez quitter la fenetre");
				livrableDOC2.setVisible(false);
		 
	 }

	private void  consulterLivrable() {
		modelvueconsulterDocLivrable2= new modelVueconsulterDocLivrable2();
		Integer index=livrableDOC2.getTableEtudiant().getSelectedRow();
		if(index == -1)
			JOptionPane.showMessageDialog(null, "Selectionner l'etudiant");
		else
		{
			String livrable=modelvueconsulterDocLivrable2.getlivrable(livrableDOC2.getDocLivrableComboBox().getSelectedItem().toString(),
					livrableDOC2.getTableEtudiant().getModel().getValueAt(index, 0).toString());
			
			livrableDOC2.getPath().setText(livrable);
		
		}
		
			
	}
	
}
