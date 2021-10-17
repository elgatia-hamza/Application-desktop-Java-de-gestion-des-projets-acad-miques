package presentation_espaceProfesseur;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import metier.pojo.Professeur;
import persistance.ConnexionBD;

public class VuesAuthentification extends JFrame{
	
	private JLabel ChoixUtilisateur;
	private JComboBox choix;
	private JTextField  textLogin;
	private JTextField textPassword;
	private JLabel labelLogin;
    private JButton connexion;
    private JLabel lebelPassword;
    private JLabel lebelbienvenu;




	public VuesAuthentification() throws HeadlessException {
		super("VuesAuthentification");
		initialiser();
		dessiner();
	}

	private void dessiner() {
		ChoixUtilisateur.setBounds(49, 87, 127, 23);
		connexion.setBounds(150, 400, 100, 30);
		lebelPassword.setBounds(49, 284, 127, 23);
		labelLogin.setBounds(49, 188, 127, 23);
		textPassword.setBounds(49, 318, 290, 30);
		choix.setBounds(49, 121, 286, 30);
		textLogin.setBounds(49, 222, 286, 30);
		add(ChoixUtilisateur);
		choix.setModel(new DefaultComboBoxModel(new String[] {"Etudiant", "Professeur", "Administrateur"}));
		add(choix);	
		add(textLogin);	
		add(labelLogin); 
		add(lebelPassword);
		add(textPassword);
        add(connexion);
       setSize(500,500);
       setLayout(null);
       this.setSize(400,500);
       setResizable(false);
      	
	}


	private void initialiser() {
		choix = new JComboBox();
		connexion = new JButton("connexion");
		lebelPassword = new JLabel("password");
		labelLogin = new JLabel("Login :");
		textPassword = new JTextField();
		textLogin = new JTextField();
		ChoixUtilisateur=new JLabel("Choix utilisateur :");
		 
		lebelbienvenu= new JLabel("Bienvenu");
		
	}


	public JComboBox getChoix() {
		return choix;
	}


	public void setChoix(JComboBox choix) {
		this.choix = choix;
	}


	public JTextField getTextLogin() {
		return textLogin;
	}


	public void setTextLogin(JTextField textLogin) {
		this.textLogin = textLogin;
	}




	public JTextField getTextPassword() {
		return textPassword;
	}


	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}


	public JButton getConnexion() {
		return connexion;
	}


	public void setConnexion(JButton connexion) {
		this.connexion = connexion;
	}





	
}