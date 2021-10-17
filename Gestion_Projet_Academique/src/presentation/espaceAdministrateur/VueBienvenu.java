package presentation.espaceAdministrateur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.gestion.ModeleVueBienvenu;


/**
 * @author Hamza
 *
 */


public class VueBienvenu extends JFrame {
	private JLabel bienvenu;
	private JLabel nom;
	private JButton gestionEtudiants;
	private JButton gestionProfesseurs;
	private JButton gestionProjets;
	private ModeleVueBienvenu modele;
	private ControlleurVueBienvenu nav;
	
	public VueBienvenu(ModeleVueBienvenu modele) {
		this.modele = modele;
		demarer();
		init();
		dessin();
		action();
		pack();	
	}
	
	public ModeleVueBienvenu getModele() {
		return modele;
	}

	public void setModele(ModeleVueBienvenu modele) {
		this.modele = modele;
	}
	
	public void demarer() {
		setTitle("Accueil");
		setSize(700, 500);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void init() {
		bienvenu = new JLabel("Bienvenue");
		nom = new JLabel("Mr. "+modele.getAdministrateurNom());
		gestionEtudiants = new JButton("Gestion des etudiants");
		gestionProfesseurs = new JButton("Gestion des professeurs");
		gestionProjets = new JButton("Gestion des projet");
		
		nav = new ControlleurVueBienvenu(this);
	}
	
	public void dessin() {
		setLayout(new BorderLayout());
		//new FlowLayout(FlowLayout.CENTER)
		
		//bienvenu.setHorizontalAlignment(JLabel.CENTER);
		bienvenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		bienvenu.setFont(new Font("Comic Sans MS", 4, 42));
		
		//nom.setHorizontalAlignment(JLabel.CENTER);
	    nom.setAlignmentX(Component.CENTER_ALIGNMENT);
	    nom.setFont(new Font("Comic Sans MS", 2, 14));
	    
	    gestionEtudiants.setHorizontalAlignment(JLabel.CENTER);
	    gestionEtudiants.setAlignmentX(Component.CENTER_ALIGNMENT);
	    gestionEtudiants.setPreferredSize(gestionProfesseurs.getPreferredSize());
	    //gestionEtudiants.setSize(gestionProfesseurs.getSize());
	    
	    gestionProfesseurs.setHorizontalAlignment(JLabel.CENTER);
	    gestionProfesseurs.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    gestionProjets.setHorizontalAlignment(JLabel.CENTER);
	    gestionProjets.setAlignmentX(Component.CENTER_ALIGNMENT);
	    gestionProjets.setPreferredSize(gestionProfesseurs.getPreferredSize());
	    
		JPanel top = new JPanel();		
		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
		//top.setBorder(BorderFactory.createTitledBorder("hi"));
		top.setPreferredSize(new Dimension(300,100));
		top.add(bienvenu);
		top.add(nom);
		add(top,BorderLayout.NORTH);
		
		Panel body = new Panel();
		body.setLayout(new FlowLayout(FlowLayout.CENTER));
		//body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		//body.setLayout(new GridLayout(3,1));
		body.setPreferredSize(new Dimension(200,200));
		body.add(gestionEtudiants);
		body.add(gestionProfesseurs);
		body.add(gestionProjets);
		add(body,BorderLayout.CENTER);
	}
	
	public void action() {
		gestionProjets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueDonneesProjets(modele);
			}
		});
		
		gestionEtudiants.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueDonneesEtudiant();
			}
		});
		
		gestionProfesseurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueDonneesProfesseur();
			}
		});
	}
	
	

}
