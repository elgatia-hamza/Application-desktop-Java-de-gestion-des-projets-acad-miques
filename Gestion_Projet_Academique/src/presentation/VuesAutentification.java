package presentation;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueAuthentification;
import metier.gestion.ModeleVueBienvenu;
import metier.pojo.Administrateur;
import metier.pojo.Etudiant;
import metier.pojo.Professeur;
import presentation_espaceProfesseur.ControlleurVueAcceuilProfesseur;
import presentation_espaceProfesseur.VueAcceuilProfesseur;

public class VuesAutentification extends JFrame{
	
    private JLabel ChoixUtilisateur;
    private JComboBox choix;
    private JTextField textLogin;
    private JPasswordField textPassword;
    private JLabel lebelLogin;
    private JButton connexion;
    private JLabel lebelPassword;
    private JPanel panel;
    private JLabel lebelbienvenu;
    private ModeleVueAuthentification modele;
    private ControlleurVueAuthentification nav;
	

	public VuesAutentification() throws HeadlessException {
		super();
		initialiser();
		dessiner();
		action();
		setVisible(true);
	}


	private void dessiner() {
		ChoixUtilisateur.setBounds(49, 87, 127, 23);
		connexion.setBounds(150, 400, 100, 30);
		lebelPassword.setBounds(49, 284, 127, 23);
		lebelLogin.setBounds(49, 188, 127, 23);
		textPassword.setBounds(49, 318, 290, 30);
		choix.setBounds(49, 121, 286, 30);
		textLogin.setBounds(49, 222, 286, 30);
		panel.add(lebelbienvenu);
		add(ChoixUtilisateur);
		choix.setModel(new DefaultComboBoxModel(new String[] {"Etudiant", "Professeur", "Administrateur"}));
		add(choix);	
		add(textLogin);	
		add(lebelLogin); 
		add(lebelPassword);
		add(textPassword);
        add(connexion);
       setSize(500,500);
        this.add(panel);
       this.setSize(400,500);
       setResizable(false);
	}


	private void initialiser() {
		choix = new JComboBox();
		connexion = new JButton("connexion");
		lebelPassword = new JLabel("password");
		textLogin = new JTextField();
		textPassword = new JPasswordField();
		lebelLogin = new JLabel("Login :");
		ChoixUtilisateur=new JLabel("Choix utilisateur :");
		panel= new JPanel();
		lebelbienvenu= new JLabel("Bienvenu");
		
		modele = new ModeleVueAuthentification();
		modele.settextLogin(textLogin);
		modele.setTextPassword(textPassword);
		nav = new ControlleurVueAuthentification();
		nav.setVue_authentification(this);
	}
	
	public void action() {
		connexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = choix.getSelectedIndex();
				switch (index) {
				case 0: {
					Etudiant etudiant = null;
					try {
						etudiant = modele.connectEtudiant();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(etudiant!=null) {
						nav.executeVueBienvenuEtudiant(new ModeleVueAccueil(etudiant));
					}
					else {
						JOptionPane.showMessageDialog(null,"Login ou password est incorrect!");
					}
					break;
				}
				case 1: {
					Professeur professeur = null;
					try {
						professeur = modele.connectProfesseur();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(professeur!=null) {
						int IDprof=Integer.valueOf(professeur.getId_professeur());
						 VueAcceuilProfesseur AcceuilProfesseur=new VueAcceuilProfesseur();
			    		AcceuilProfesseur.getLabelPrNom().setText("Mr."+professeur.getNom().toUpperCase());
			    		ControlleurVueAcceuilProfesseur controlleur2 = new ControlleurVueAcceuilProfesseur(AcceuilProfesseur,IDprof);
			    		AcceuilProfesseur.setVisible(true);
			    		setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Login ou password est incorrect!");
					}
					break;
				}

				case 2: {
					Administrateur admin = null;
					try {
						admin = modele.connectAdministrateur();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(admin!=null) {
						nav.executeVueBienvenuAdministrateur(new ModeleVueBienvenu(admin));
					}else {
						JOptionPane.showMessageDialog(null,"Login ou password est incorrect!");
					}
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + index);
				}	
			}
		});
	}
}
