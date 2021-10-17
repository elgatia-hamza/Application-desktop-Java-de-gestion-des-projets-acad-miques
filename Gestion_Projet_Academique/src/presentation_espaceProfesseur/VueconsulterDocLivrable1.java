package presentation_espaceProfesseur;

import java.awt.HeadlessException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueconsulterDocLivrable1 extends JFrame{
	private JLabel labelSelectFiliere;
	private JComboBox FilierecomboBox;
	private JLabel labelSelectType;
	private JComboBox TypecomboBox;
	private JButton TrouverButton;
	public VueconsulterDocLivrable1() throws HeadlessException {
		super("VueconsulterDocLivrable1");
		initialiser();
		dessiner();
		}
	
	public JComboBox getFilierecomboBox() {
		return FilierecomboBox;
	}

	public void setFilierecomboBox(JComboBox filierecomboBox) {
		FilierecomboBox = filierecomboBox;
	}

	public JComboBox getTypecomboBox() {
		return TypecomboBox;
	}

	public void setTypecomboBox(JComboBox typecomboBox) {
		TypecomboBox = typecomboBox;
	}

	public JButton getTrouverButton() {
		return TrouverButton;
	}

	public void setTrouverButton(JButton trouverButton) {
		TrouverButton = trouverButton;
	}

	private void dessiner() {
		labelSelectFiliere.setBounds(44, 131, 130, 14);
		FilierecomboBox.setModel(new DefaultComboBoxModel(new String[] {"IID", "GI", "GE", "GRT", "GP","BIG DATA"}));
		FilierecomboBox.setBounds(207, 128, 112, 20);
		labelSelectType.setBounds(44, 192, 119, 14);
		TypecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Fin d'année", "Fin d'étude","Doctorat"}));
		TypecomboBox.setBounds(207, 189, 112, 20);
		TrouverButton.setBounds(257, 319, 89, 23);
		add(labelSelectFiliere);
		add(FilierecomboBox);
		add(labelSelectType);
		add(TypecomboBox);
		add(TrouverButton);
		
		setSize(500,500);
		 setLayout(null);
		setResizable(false);
		
		
	}
	private void initialiser() {
		labelSelectFiliere = new JLabel("selectionnez la filiere :");
		FilierecomboBox = new JComboBox();
		labelSelectType = new JLabel("selectionnez le type :");
		TypecomboBox = new JComboBox();
		TrouverButton = new JButton("Trouver");
		
	}

}
