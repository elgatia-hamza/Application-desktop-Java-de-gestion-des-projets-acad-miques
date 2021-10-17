package presentation.espaceEtudiant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueDeposerUnDocument;
import metier.gestion.ModeleVueDonneesEtudiant;
import metier.pojo.Etudiant;

public class VueDeposerUnDocument extends JFrame {
	private ModeleVueDeposerUnDocument modele1;
	private JComboBox typeDocuments;
	private JTextField txtMotsCles;
	private JTextField path;
	private JTextField titre;
	private JButton reteur;
	private JButton envoyer;
	private ControlleurVueDeposerUnDocument navigateur;


	public VueDeposerUnDocument(ModeleVueDeposerUnDocument modele) {
		this.modele1=modele;
		demarer();
		initialise();
		design();
		action();
	}
	public void demarer() {
		setTitle("Deposer Un Document");
		setVisible(true);
		setSize(700, 500);
	}
	
	public void initialise() {
		navigateur = new ControlleurVueDeposerUnDocument(this);
		reteur = new JButton("< reteur");
		typeDocuments = new JComboBox();
		titre = new JTextField();
		txtMotsCles = new JTextField();
		path = new JTextField();
		envoyer = new JButton("envoyer");
		modele1.setTitre(titre);
		modele1.setTxtLienDuDocument(path);
		modele1.setTxtMotsCles(txtMotsCles);
		modele1.setTypeDocuments(typeDocuments);
	}
	public void design() {
		typeDocuments.setModel(new DefaultComboBoxModel(new String[] {"Livrable1", "Livrable2", "Livrable3","Rapport" }));
		reteur.setBounds(50, 400, 100, 25);
	
		
		typeDocuments.setBounds(200, 150, 300, 30);
		titre.setText("Titre:");
		titre.setBounds(200, 200, 300, 30);
		txtMotsCles.setText("Mots cles separer par des ; ");
		txtMotsCles.setBounds(200, 300, 300, 30);
	
		path.setText("lien du document");
		path.setBounds(200, 250, 300, 30);
		
		envoyer.setBounds(550, 400, 100, 25);
		
		add(typeDocuments);
		add(txtMotsCles);
		add(titre);
		add(path);
		add(reteur);
		add(envoyer);
		setLayout(null);
		
		
	}
	public void action() {
		envoyer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modele1.deposerDocument()) {
					
					JOptionPane.showMessageDialog(null, "1 Document est ajouter ", "Message", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "les donnees sont incorrect!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		 reteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigateur.reteur(modele1.getEtudiant());
				
			}
		});
		
	}
	
	

}
