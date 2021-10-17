package presentation.espaceAdministrateur;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.gestion.ModeleTableProjet;
import metier.gestion.ModeleVueDonneesProjets;


/**
 * @author Hamza
 *
 */

public class VueEditProjet extends JFrame{
	private JTable table;
	private JTabbedPane tabbedPane;
	private JLabel id1;
	private JLabel id2;
	private JTextField idText1;
	private JTextField idText2;
	private JButton recherche1;
	private JButton recherche2;
	private ModeleVueDonneesProjets modele;
	private ControlleurEditProjet nav;
	
	public VueEditProjet(ModeleVueDonneesProjets modele) {
		this.modele = modele;
		init();
		dessin();
		action();
		demarer();
	}
	
	public void demarer() {
		setTitle("Données Projets");
		setSize(1000, 500);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void init() {
		table = new JTable(modele.getModelProjet());
		
		tabbedPane = new JTabbedPane();
		
		id1 = new JLabel("Id Projet");
		id1.setMaximumSize(new Dimension(300,20));
		id2 = new JLabel("Id Projet");
		id2.setMaximumSize(new Dimension(300,20));
		idText1 = new JTextField();
		idText1.setMaximumSize(new Dimension(300,20));
		idText2 = new JTextField();
		idText2.setMaximumSize(new Dimension(300,20));
		
		recherche1 = new JButton("Recherche");
		recherche2 = new JButton("Recherche");
		
		nav = new ControlleurEditProjet(this);
	}
	
	public void dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		table.setRowHeight(15);
		table.setFont(new Font("Segoe UI", 1, 12));
		JScrollPane s = new JScrollPane(table);
		s.setBorder(BorderFactory.createTitledBorder("Liste des projets"));
		s.setMaximumSize(new Dimension(1000,500));
		content.add(s);
		
		JPanel panelModifier = new JPanel();
		panelModifier.setLayout(new BoxLayout(panelModifier,BoxLayout.Y_AXIS));
		
		JPanel panelSupprimer = new JPanel();
		panelSupprimer.setLayout(new BoxLayout(panelSupprimer,BoxLayout.Y_AXIS));
		
		JPanel r1 = new JPanel();
		r1.setLayout(new BoxLayout(r1,BoxLayout.X_AXIS));
		r1.add(id1);
		r1.add(idText1);
		panelModifier.add(r1);
		panelModifier.add(recherche1);
		
		JPanel r2 = new JPanel();
		r2.setLayout(new BoxLayout(r2,BoxLayout.X_AXIS));
		r2.add(id2);
		r2.add(idText2);
		panelSupprimer.add(r2);
		panelSupprimer.add(recherche2);
		
		tabbedPane.add(panelModifier,"Modifier");
		tabbedPane.add(panelSupprimer,"Supprimer");
		
		content.add(tabbedPane);
		
		setContentPane(content);
	}
	
	public void action() {
		recherche1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modele.setId_projetText(idText1);
				if(modele.rechercheIdProjet()) {
					nav.exercuteVuNouvelleDonneeProjet(modele);
				}else {
					JOptionPane.showMessageDialog(null, "Id projet est n'exist pas!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		recherche2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modele.setId_projetText(idText2);
				if(modele.rechercheIdProjet()) {
					int choix = JOptionPane.showConfirmDialog(null, "Voullez-vous vraiment supprimer ce projet? " , "Supprimer...", JOptionPane.YES_NO_CANCEL_OPTION);
					if(choix == 0) {
						modele.supprimerProjet();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Id projet est n'exist pas!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
