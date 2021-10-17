package metier.gestion;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import metier.pojo.Administrateur;
import metier.pojo.Etudiant;
import metier.pojo.Professeur;
import persistance.DAOAdministrateur;
import persistance.DAOEtudiant;
import persistance.DAOProfesseur;

public class ModeleVueAuthentification {
	 private JTextField textLogin;
	 private JPasswordField textPassword;

	public ModeleVueAuthentification() {
		super();
	}

	public ModeleVueAuthentification(JTextField textLogin, JPasswordField textPassword) {
		super();
		this.textLogin = textLogin;
		this.textPassword = textPassword;
	}

	public JTextField gettextLogin() {
		return textLogin;
	}

	public void settextLogin(JTextField textLogin) {
		this.textLogin = textLogin;
	}

	public JPasswordField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JPasswordField textPassword) {
		this.textPassword = textPassword;
	}
	
	
	public Etudiant connectEtudiant() throws ClassNotFoundException {
		String login = textLogin.getText();
		String password = textPassword.getText();
		DAOEtudiant table = new DAOEtudiant();
		ArrayList<Etudiant> listEtudiant = table.getAll();
		//HashMap<String, String> comptes = new HashMap<String, String>();
		for (Etudiant etudiant : listEtudiant) {
			if(login.equals(etudiant.getLogin()) && password.equals(etudiant.getPassword()))
				return etudiant;
		}
		
		return null;
	}
	
	public Professeur connectProfesseur() throws ClassNotFoundException {
		String login = textLogin.getText();
		String password = textPassword.getText();
		DAOProfesseur table = new DAOProfesseur();
		ArrayList<Professeur> listProfesseur = table.getAll();
		//HashMap<String, String> comptes = new HashMap<String, String>();
		for (Professeur professeur : listProfesseur) {
			if(login.equals(professeur.getLogin()) && password.equals(professeur.getPassword()))
				return professeur;
		}
		
		return null;
	}
	
	public Administrateur connectAdministrateur() throws ClassNotFoundException {
		String login = textLogin.getText();
		String password = textPassword.getText();
		DAOAdministrateur table = new DAOAdministrateur();
		ArrayList<Administrateur> listAdministrateur = table.getAll();
		//HashMap<String, String> comptes = new HashMap<String, String>();
		for (Administrateur administrateur : listAdministrateur) {
			if(login.equals(administrateur.getLogin()) && password.equals(administrateur.getPassword()))
				return administrateur;
		}
		
		return null;
	}
	
}
