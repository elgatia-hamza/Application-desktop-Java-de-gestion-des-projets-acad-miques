package presentation.espaceEtudiant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueBienvenu;
import presentation.espaceAdministrateur.ControlleurVueBienvenu;


public class VueAccueil extends JFrame {
	private JButton Button1;
	private JButton Button2;
	private JButton Button3;
	private JLabel nom;
	private JLabel bienvenu;
	private ModeleVueAccueil modele;
	private ControlleurVueAccueil nav;
	public VueAccueil(ModeleVueAccueil modele_Accueil) {
		this.modele = modele_Accueil;
		demarer();
		initialise();
		design();
		Action();
	}
	public void demarer() {
		setTitle("Accueil");
		setSize(700, 500);
		setVisible(true);
	}
	public void initialise() {
		bienvenu = new JLabel("Bienvenue");
		nom = new JLabel("Mr. "+modele.getEtudiantNom());	
		nav = new ControlleurVueAccueil(this);
		Button1 = new JButton("Mes rendez vous");
		Button2 = new JButton("La liste des documents");
	}
	public void design() {
		bienvenu.setBounds(315, 50, 100, 35);
		nom.setBounds(300, 100, 100, 35);
		Button1.setBounds(225, 200, 250, 30);
		Button2.setBounds(225, 250, 250, 30);
		add(bienvenu);
		add(nom);
		add(Button1);
		add(Button2);
		setLayout(null);
	}
	public void Action() {
		Button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueMesRendezVous(modele.getEtudiant());
				
			}
		});
		
		Button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueLaListeDesDocuments(modele.getEtudiant());
			}
		});
	}
	
}
