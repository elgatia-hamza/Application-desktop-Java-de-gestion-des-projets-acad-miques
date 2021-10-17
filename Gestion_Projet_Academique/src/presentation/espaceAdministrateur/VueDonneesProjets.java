package presentation.espaceAdministrateur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import metier.gestion.ModeleTableProjet;
import metier.gestion.ModeleVueDonneesProjets;
import metier.pojo.Administrateur;
import metier.pojo.Projet;

public class VueDonneesProjets extends JFrame{
	private JTable table;
	private ModeleTableProjet model;
	private JButton consulter_statistique;
	private JButton ajouter;
	private JButton modifier;
	private JButton supprimer;
	private ModeleVueDonneesProjets modele;
	private ControlleurVueDonneesProjets nav;
	
	public VueDonneesProjets(ModeleVueDonneesProjets modele) {
		this.modele = modele;
		init();
		dessin();
		action();
		demarer();
	}
	
	public ModeleVueDonneesProjets getModele() {
		return modele;
	}

	public void setModele(ModeleVueDonneesProjets modele) {
		this.modele = modele;
	}

	public void demarer() {
		setTitle("Données Projets");
		setSize(1000, 500);
		//pack();
		//setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void init() {
		ArrayList<Projet> listProjets = modele.getListeProjets();
		model = new ModeleTableProjet(listProjets);
		table  = new JTable(model);
		
		consulter_statistique = new JButton("Consulter les statistiques");
		ajouter = new JButton("Ajouter");
		modifier = new JButton("Modifier");
		supprimer = new JButton("Supprimer");
		
		nav = new ControlleurVueDonneesProjets(this);
		modele.setModelProjet(model);
	}
	
	public void dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		table.setRowHeight(15);
		table.setFont(new Font("Segoe UI", 1, 12));
		JScrollPane s = new JScrollPane(table);
		s.setBorder(BorderFactory.createTitledBorder("Liste des projets"));
		content.add(s);
		
		JPanel panel1 = new JPanel();
		panel1.add(consulter_statistique);
		content.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.add(ajouter);
		panel2.add(modifier);
		panel2.add(supprimer);
		content.add(panel2);
		
		setContentPane(content);

	}
	
	public void action() {
		consulter_statistique.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.exercuteVueStatistique(modele);
			}
		});
		
		modifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueEditProjet(modele);	
			}
		});
		
		supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.executeVueEditProjet(modele);
			}
		});
		
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nav.exercuteVueAjouterProjet(modele);
				
			}
		});
	}
}
