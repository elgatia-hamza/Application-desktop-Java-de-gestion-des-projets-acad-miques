package presentation_espaceProfesseur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import metier.gestion.ModeleTableEtudiant;

public class VueconsulterDocLivrable2 extends JFrame {

	private JButton ButtonConsulterDoc;
	private JComboBox DocLivrableComboBox;
	private JLabel lblNewLabel ;
	private JButton valideButton;
	private JTable  tableEtudiant;
	private JScrollPane scroll;
	private JLabel path;

	
	public VueconsulterDocLivrable2() {
		super("VueconsulterDocLivrable2");
		initialiser();
		dessiner();
		
	}
	public JTable getTableEtudiant() {
		return tableEtudiant;
	}
	public void setTableEtudiant(JTable tableEtudiant) {
		this.tableEtudiant = tableEtudiant;
	}
	public JLabel getPath() {
		return path;
	}
	public void setPath(JLabel path) {
		this.path = path;
	}
	public JButton getButtonConsulterDoc() {
		return ButtonConsulterDoc;
	}
	public void setButtonConsulterDoc(JButton buttonConsulterDoc) {
		ButtonConsulterDoc = buttonConsulterDoc;
	}
	public JComboBox getDocLivrableComboBox() {
		return DocLivrableComboBox;
	}
	public void setDocLivrableComboBox(JComboBox docLivrableComboBox) {
		DocLivrableComboBox = docLivrableComboBox;
	}
	public JButton getValideButton() {
		return valideButton;
	}
	public void setValideButton(JButton valideButton) {
		this.valideButton = valideButton;
	}
	private void dessiner() {

		ButtonConsulterDoc.setBounds(105, 313, 154, 23);
		DocLivrableComboBox.setModel(new DefaultComboBoxModel(new String[] {"livrable1", "livrable2", "livrable3"}));
		DocLivrableComboBox.setBounds(309, 314, 169, 21);
		lblNewLabel.setBounds(10, 412, 531, 14);
		valideButton.setBounds(452, 498, 89, 23);
		scroll.setBounds(10, 11, 550, 218);
		path.setBounds(150, 460, 550, 14);
	    tableEtudiant.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		add(ButtonConsulterDoc);
		add(DocLivrableComboBox);
		add(lblNewLabel);
		add(valideButton);
		add(scroll);
		add(path);
		 setLayout(null);
		setSize(600,600);
		setResizable(false);
		
	}
	private void initialiser() {
		ButtonConsulterDoc = new JButton("consulter");
		DocLivrableComboBox= new JComboBox();
		lblNewLabel = new JLabel("lien de document");
		valideButton = new JButton("Quitter");
		tableEtudiant = new JTable();
		scroll=new JScrollPane(tableEtudiant);
		path=new JLabel();
			
	}

}
