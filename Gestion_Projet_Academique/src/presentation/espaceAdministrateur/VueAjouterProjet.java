

package presentation.espaceAdministrateur;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableProfesseur;
import metier.gestion.ModeleTableProjet;
import metier.gestion.ModeleVueDonneesProjets;

/**
 * @author Hamza
 *
 */
public class VueAjouterProjet extends JFrame{
	private JTable tableEtudiant;
	private JTable tableProfesseur;
	private ModeleTableEtudiant modelEtudiant;
	private ModeleTableProfesseur modelProfesseur;
	private JLabel theme_projet;
	private JLabel cne;
	private JLabel id_professeur;
	private JLabel type;	
	private JLabel cloture;
	private JLabel duree;
	private JTextField theme_projetText;
	private JTextField cneText;
	private JTextField id_professeurText;
	private JComboBox<String> typelist;
	private JTextField clotureText;
	private JTextField dureeText;
	private JButton ajouter;
	private ModeleVueDonneesProjets modele;
	private ControlleurVueDonneesProjets nav;
	
	public VueAjouterProjet(ModeleVueDonneesProjets modele) {
		this.modele = modele;
		init();
		dessin();
		action();
		demarer();
	}
	
	
	
	public ControlleurVueDonneesProjets getNav() {
		return nav;
	}
	
	public void setNav(ControlleurVueDonneesProjets nav) {
		this.nav = nav;
	}

	
	
	public void demarer() {
		setTitle("Ajouter Projet");
		setSize(1100, 500);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void init() {
		modelEtudiant = new ModeleTableEtudiant(modele.getListeEtudiants());
		tableEtudiant = new JTable(modelEtudiant);
		
		modelProfesseur = new ModeleTableProfesseur(modele.getListeProfesseurs());
		tableProfesseur = new JTable(modelProfesseur);
		
		theme_projet = new JLabel("Théme Projet");
		cne = new JLabel("CNE");
		id_professeur = new JLabel("Id Professeur");
		type = new JLabel("Type");
		cloture = new JLabel("Cloture");
		duree = new JLabel("Duree");
		
		theme_projetText = new JTextField();
		cneText = new JTextField();
		id_professeurText = new JTextField();  
		typelist = new JComboBox<String>(new String[] {"Fin d'année", "Fin d'étude","Doctorat"});
		clotureText = new JTextField();
		dureeText = new JTextField();
		
		ajouter = new JButton("Ajouter");
		modele.setClotureText(clotureText);
		modele.setId_professeurText(id_professeurText);
		modele.setCneText(cneText);
		modele.setDureeText(dureeText);
		modele.setTheme_projetText(theme_projetText);
		modele.setTypelist(typelist);
	}
	
	public void dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.X_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setMaximumSize(new Dimension(700,700));
		tableEtudiant.setRowHeight(15);
		tableEtudiant.setFont(new Font("Segoe UI", 1, 12));
		JScrollPane s1 = new JScrollPane(tableEtudiant);
		s1.setBorder(BorderFactory.createTitledBorder("Liste des etudiants"));
		panel1.add(s1);
		
		tableProfesseur.setRowHeight(15);
		tableProfesseur.setFont(new Font("Segoe UI", 1, 12));
		JScrollPane s2 = new JScrollPane(tableProfesseur);
		s2.setBorder(BorderFactory.createTitledBorder("Liste des professeurss"));
		panel1.add(s2);
		content.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.setBorder(BorderFactory.createTitledBorder("Ajouter Projet"));
		
		JPanel r1 = new JPanel();
		r1.setLayout(new BoxLayout(r1, BoxLayout.X_AXIS));
		theme_projet.setMaximumSize(new Dimension(200,30));
		theme_projetText.setMaximumSize(new Dimension(200,30));
		r1.add(theme_projet);
		r1.add(theme_projetText);
		panel2.add(r1);
		
		JPanel r2 = new JPanel();
		r2.setLayout(new BoxLayout(r2, BoxLayout.X_AXIS));
		cne.setMaximumSize(new Dimension(200,30));
		cneText.setMaximumSize(new Dimension(200,30));
		r2.add(cne);
		r2.add(cneText);
		panel2.add(r2);
		
		JPanel r3 = new JPanel();
		r3.setLayout(new BoxLayout(r3, BoxLayout.X_AXIS));
		id_professeur.setMaximumSize(new Dimension(200,30));
		id_professeurText.setMaximumSize(new Dimension(200,30));
		r3.add(id_professeur);
		r3.add(id_professeurText);
		panel2.add(r3);
		
		JPanel r4 = new JPanel();
		r4.setLayout(new BoxLayout(r4, BoxLayout.X_AXIS));
		type.setMaximumSize(new Dimension(200,30));
		typelist.setMaximumSize(new Dimension(200,30));
		r4.add(type);
		r4.add(typelist);
		panel2.add(r4);
		
		JPanel r5 = new JPanel();
		r5.setLayout(new BoxLayout(r5, BoxLayout.X_AXIS));
		cloture.setMaximumSize(new Dimension(200,30));
		clotureText.setMaximumSize(new Dimension(200,30));
		r5.add(cloture);
		r5.add(clotureText);
		panel2.add(r5);
		
		JPanel r6 = new JPanel();
		r6.setLayout(new BoxLayout(r6, BoxLayout.X_AXIS));
		duree.setMaximumSize(new Dimension(200,30));
		dureeText.setMaximumSize(new Dimension(200,30));
		r6.add(duree);
		r6.add(dureeText);
		panel2.add(r6);
		
		panel2.add(ajouter);
		
		content.add(panel2);
		setContentPane(content);
		
	}
	
	public void action() {
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modele.add()) {
					JOptionPane.showMessageDialog(null, "1 projet est ajouter ", "Message", JOptionPane.INFORMATION_MESSAGE);
					modele.reset();
				}else {
					JOptionPane.showMessageDialog(null, "les donnees sont incorrect!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}

}
