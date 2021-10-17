package presentation_espaceProfesseur;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VueStatistqueDavancement extends JFrame {
	
	
    private JTable tableEtudiant;
    private JTable tableProjet;
    private JLabel lblConsultationChqPjt;
    private JTextField IdProjetTextField ;
    private JButton ButtonConsulterChq;
    private JLabel lblConsultationDavancement;
	private JComboBox TypePjtcomboBox;
	private JButton ButtonConsulterParType;
	private JButton ButtonCosulterTous ;
	private JLabel labelAvncPorcentage1;
	private JLabel labelAvncPorcentage2;
	private JLabel labelAvncPorcentage3;
	private JScrollPane scroll;
	private JScrollPane scroll2;

	
	public VueStatistqueDavancement() throws HeadlessException {
		super("VueStatistqueDavancement");
		initialiser();
		dessiner();
	}
	private void dessiner() {
		scroll.setBounds(2, 21, 470, 218);
		scroll2.setBounds(498, 21, 470, 218);
		lblConsultationChqPjt.setBounds(60, 359, 300, 14);
		IdProjetTextField.setBounds(339, 356, 122, 22);
		IdProjetTextField.setColumns(10);
		ButtonConsulterChq.setBounds(506, 355, 128, 23);
		lblConsultationDavancement.setBounds(60, 443, 300, 14); 
		TypePjtcomboBox.setBounds(339, 440, 122, 20);
		ButtonConsulterParType.setBounds(506, 439, 128, 23);
		ButtonCosulterTous.setBounds(310, 551, 350, 28);
		labelAvncPorcentage1.setBounds(749, 359, 80, 14);
		labelAvncPorcentage2.setBounds(749, 443, 80, 14);
		labelAvncPorcentage3.setBounds(749, 558,80, 14);
		add(scroll);
		add(scroll2);
		add(lblConsultationChqPjt);
		add(IdProjetTextField);
		add(ButtonConsulterChq);
		add(lblConsultationDavancement);
		TypePjtcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Fin d'année", "Fin d'étude","Doctorat"}));
		add(TypePjtcomboBox);
		add(ButtonConsulterParType);
		add(ButtonCosulterTous);
		add(labelAvncPorcentage1);
		add(labelAvncPorcentage2);
		add(labelAvncPorcentage3);
		tableEtudiant.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProjet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 setLayout(null);
		setSize(1000,700);
	    setResizable(false);
	    
	}
	private void initialiser() {
		tableEtudiant = new JTable();
		tableProjet = new JTable();
		lblConsultationChqPjt = new JLabel("Consulter l'etat d'avancement par ID Projet :");
		IdProjetTextField = new JTextField();
		ButtonConsulterChq = new JButton("consulter");
		lblConsultationDavancement = new JLabel("Consultation d 'avancement par type de projet :");
		TypePjtcomboBox = new JComboBox();
		ButtonConsulterParType = new JButton("consulter");
		ButtonCosulterTous = new JButton("Consultation l'etat d'avancement de tous les projets");
		labelAvncPorcentage1 = new JLabel("0%");
		labelAvncPorcentage2 = new JLabel("0%");
		labelAvncPorcentage3 = new JLabel("0%");
		scroll= new JScrollPane(tableEtudiant);
		scroll2=new JScrollPane(tableProjet);
	}
	public JTable getTableEtudiant() {
		return tableEtudiant;
	}
	public void setTableEtudiant(JTable tableEtudiant) {
		this.tableEtudiant = tableEtudiant;
	}
	public JTable getTableProjet() {
		return tableProjet;
	}
	public void setTableProjet(JTable tableProjet) {
		this.tableProjet = tableProjet;
	}
	public JTextField getIdProjetTextField() {
		return IdProjetTextField;
	}
	public void setIdProjetTextField(JTextField idProjetTextField) {
		IdProjetTextField = idProjetTextField;
	}
	public JButton getButtonConsulterChq() {
		return ButtonConsulterChq;
	}
	public void setButtonConsulterChq(JButton buttonConsulterChq) {
		ButtonConsulterChq = buttonConsulterChq;
	}
	public JComboBox getTypePjtcomboBox() {
		return TypePjtcomboBox;
	}
	public void setTypePjtcomboBox(JComboBox typePjtcomboBox) {
		TypePjtcomboBox = typePjtcomboBox;
	}
	public JButton getButtonConsulterParType() {
		return ButtonConsulterParType;
	}
	public void setButtonConsulterParType(JButton buttonConsulterParType) {
		ButtonConsulterParType = buttonConsulterParType;
	}
	public JButton getButtonCosulterTous() {
		return ButtonCosulterTous;
	}
	public void setButtonCosulterTous(JButton buttonCosulterTous) {
		ButtonCosulterTous = buttonCosulterTous;
	}
	public JLabel getLabelAvncPorcentage1() {
		return labelAvncPorcentage1;
	}
	public void setLabelAvncPorcentage1(JLabel labelAvncPorcentage1) {
		this.labelAvncPorcentage1 = labelAvncPorcentage1;
	}
	public JLabel getLabelAvncPorcentage2() {
		return labelAvncPorcentage2;
	}
	public void setLabelAvncPorcentage2(JLabel labelAvncPorcentage2) {
		this.labelAvncPorcentage2 = labelAvncPorcentage2;
	}
	public JLabel getLabelAvncPorcentage3() {
		return labelAvncPorcentage3;
	}
	public void setLabelAvncPorcentage3(JLabel labelAvncPorcentage3) {
		this.labelAvncPorcentage3 = labelAvncPorcentage3;
	}

	
}