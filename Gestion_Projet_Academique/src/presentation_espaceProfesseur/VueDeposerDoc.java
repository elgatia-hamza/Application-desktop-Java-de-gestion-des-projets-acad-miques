package presentation_espaceProfesseur;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VueDeposerDoc extends JFrame{
	
	
	
    private JLabel labelmotCle;
    private JLabel labelLien;
    private JTextField textCle;
    private JTextField texLien;
    private JButton buttonEnvoyer;
    private JLabel labelTitre;
    private JTextField textTitre;
    private JLabel labeltype;
    private JComboBox<String> TypeDocument;;


	public VueDeposerDoc() throws HeadlessException {
		super("VueDeposerDoc");
		initialiser();
     	dessiner();
	}
	public JComboBox<String> getTypeDocument() {
		return TypeDocument;
	}
	public void setTypeDocument(JComboBox<String> typeDocument) {
		TypeDocument = typeDocument;
	}
	public JTextField getTextTitre() {
		return textTitre;
	}
	public void setTextTitre(JTextField textTitre) {
		this.textTitre = textTitre;
	}
	public JButton getButtonEnvoyer() {
		return buttonEnvoyer;
	}
	public void setButtonEnvoyer(JButton buttonEnvoyer) {
		this.buttonEnvoyer = buttonEnvoyer;
	}

	public JTextField getTextCle() {
		return textCle;
	}
	public void setTextCle(JTextField textCle) {
		this.textCle = textCle;
	}
	public JTextField getTexLien() {
		return texLien;
	}
	public void setTexLien(JTextField texLien) {
		this.texLien = texLien;
	}

	private void initialiser() {
		labelmotCle = new JLabel("Entrez Mot Cle :");
		labelLien = new JLabel("Lien du document :");

		textCle = new JTextField();
		texLien = new JTextField();
		buttonEnvoyer = new JButton("Envoyer");
		labelTitre = new JLabel("Titre du document :");
		textTitre = new JTextField();
		TypeDocument= new JComboBox<String>();
		labeltype=new JLabel("Type du document :");

	}
	private void dessiner() {	
		labelmotCle.setBounds(26, 237, 156, 14);
		add(labelmotCle);
		labelLien.setBounds(26, 377, 290, 14);
		add(labelLien);
		textCle.setBounds(180, 229, 260, 28);
		add(textCle);
		textTitre.setBounds(180, 299, 260, 28);
		textCle.setColumns(10);	
		texLien.setColumns(10);
		texLien.setBounds(180, 370, 500, 28);
		labelTitre.setBounds(26, 307, 156, 14);
		add(labelTitre);
		add(texLien);
		add(textTitre);
	    TypeDocument.setModel(new DefaultComboBoxModel(new String[] {"Consigne du projet","Cahier de charge"}));
		TypeDocument.setBounds(180, 150, 200, 28);
		labeltype.setBounds(26, 155, 156, 14);
		add(TypeDocument);
		buttonEnvoyer.setBounds(400, 460, 95, 30);
		add(labeltype);
		add(buttonEnvoyer);
		 setLayout(null);
		setSize(700,600);
		setResizable(false);
	}

   
}
