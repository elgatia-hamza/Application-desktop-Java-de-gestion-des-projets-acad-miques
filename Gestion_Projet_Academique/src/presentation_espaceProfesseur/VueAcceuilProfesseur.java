package presentation_espaceProfesseur;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAcceuilProfesseur extends JFrame{

	
	private JButton buttonStatistiqueAvn;
	private JButton ButtonConsultRpprt;
	private JButton ButtonconsultDocLivrable;
	private JButton buttonDeposeDoc;
	private JLabel labelBenvenu;
	private  JLabel labelPrNom;
	
	public VueAcceuilProfesseur() throws HeadlessException {
		super("VueAcceuilProfesseur");
	 	initialiser();
		dessiner();
	}

	private void dessiner() {
		labelBenvenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonStatistiqueAvn.setBounds(110, 164, 300, 32);	
		ButtonConsultRpprt.setBounds(110, 224, 300,32);
		ButtonconsultDocLivrable.setBounds(110, 286, 300,32);	
		buttonDeposeDoc.setBounds(110, 348, 300, 32);		

		labelBenvenu.setBounds(161, 52, 131, 25);	
		labelPrNom.setBounds(188, 107, 120, 14);
		this.add(labelPrNom);
		this.add(buttonStatistiqueAvn);
		this.add(ButtonConsultRpprt);
		this.add(ButtonconsultDocLivrable);
		this.add(buttonDeposeDoc);
		
         setLayout(null);
	    this.setSize(500,500);
	    setResizable(false);
		

	}
	private void initialiser() {
		 buttonStatistiqueAvn = new JButton("Statistique d'avancement");
		 ButtonConsultRpprt = new JButton("consulter le rapport");
		 ButtonconsultDocLivrable = new JButton("consulter les documents livrables");
		 buttonDeposeDoc = new JButton("deposer un document");
		 labelBenvenu = new JLabel("Bienvenu");
		 labelPrNom = new JLabel("Mr.Pr");
	}
	public JButton getButtonStatistiqueAvn() {
		return buttonStatistiqueAvn;
	}
	public void setButtonStatistiqueAvn(JButton buttonStatistiqueAvn) {
		this.buttonStatistiqueAvn = buttonStatistiqueAvn;
	}
	public JButton getButtonConsultRpprt() {
		return ButtonConsultRpprt;
	}
	public void setButtonConsultRpprt(JButton buttonConsultRpprt) {
		ButtonConsultRpprt = buttonConsultRpprt;
	}
	public JButton getButtonconsultDocLivrable() {
		return ButtonconsultDocLivrable;
	}
	public void setButtonconsultDocLivrable(JButton buttonconsultDocLivrable) {
		ButtonconsultDocLivrable = buttonconsultDocLivrable;
	}
	public JButton getButtonDeposeDoc() {
		return buttonDeposeDoc;
	}
	public void setButtonDeposeDoc(JButton buttonDeposeDoc) {
		this.buttonDeposeDoc = buttonDeposeDoc;
	}
	public JLabel getLabelBenvenu() {
		return labelBenvenu;
	}
	public void setLabelBenvenu(JLabel labelBenvenu) {
		this.labelBenvenu = labelBenvenu;
	}
	public JLabel getLabelPrNom() {
		return labelPrNom;
	}
	public void setLabelPrNom(JLabel labelPrNom) {
		this.labelPrNom = labelPrNom;
	}


	
}
