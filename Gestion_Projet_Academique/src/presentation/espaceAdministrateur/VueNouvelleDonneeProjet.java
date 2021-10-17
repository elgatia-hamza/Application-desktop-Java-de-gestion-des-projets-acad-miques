package presentation.espaceAdministrateur;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.gestion.ModeleVueDonneesProjets;
import metier.pojo.Administrateur;


/**
 * @author Hamza
 *
 */

public class VueNouvelleDonneeProjet extends JFrame{
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
	private JButton mettre_a_jour;
	private ModeleVueDonneesProjets modele;
	
	public VueNouvelleDonneeProjet(ModeleVueDonneesProjets modele) {
		this.modele = modele;
		init();
		dessin();
		action();
		demarer();
	}
	
	public void demarer() {
		setTitle("Nouvelles données");
		setSize(700, 500);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	
	public void init() {
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
		
		mettre_a_jour = new JButton("Mettre à jour");
		
		modele.setTheme_projetText(theme_projetText);
		modele.setCneText(cneText);
		modele.setId_professeurText(id_professeurText);
		modele.setTypelist(typelist);
		modele.setClotureText(clotureText);
		modele.setDureeText(dureeText);
	}
	
	public void dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createTitledBorder("Enter nouvelles données"));
		
		JPanel r1 = new JPanel();
		r1.setLayout(new BoxLayout(r1, BoxLayout.X_AXIS));
		theme_projet.setMaximumSize(new Dimension(200,30));
		theme_projetText.setMaximumSize(new Dimension(200,30));
		r1.add(theme_projet);
		r1.add(theme_projetText);
		content.add(r1);
		
		JPanel r2 = new JPanel();
		r2.setLayout(new BoxLayout(r2, BoxLayout.X_AXIS));
		cne.setMaximumSize(new Dimension(200,30));
		cneText.setMaximumSize(new Dimension(200,30));
		r2.add(cne);
		r2.add(cneText);
		content.add(r2);
		
		JPanel r3 = new JPanel();
		r3.setLayout(new BoxLayout(r3, BoxLayout.X_AXIS));
		id_professeur.setMaximumSize(new Dimension(200,30));
		id_professeurText.setMaximumSize(new Dimension(200,30));
		r3.add(id_professeur);
		r3.add(id_professeurText);
		content.add(r3);
		
		JPanel r4 = new JPanel();
		r4.setLayout(new BoxLayout(r4, BoxLayout.X_AXIS));
		type.setMaximumSize(new Dimension(200,30));
		typelist.setMaximumSize(new Dimension(200,30));
		r4.add(type);
		r4.add(typelist);
		content.add(r4);
		
		JPanel r5 = new JPanel();
		r5.setLayout(new BoxLayout(r5, BoxLayout.X_AXIS));
		cloture.setMaximumSize(new Dimension(200,30));
		clotureText.setMaximumSize(new Dimension(200,30));
		r5.add(cloture);
		r5.add(clotureText);
		content.add(r5);
		
		JPanel r6 = new JPanel();
		r6.setLayout(new BoxLayout(r6, BoxLayout.X_AXIS));
		duree.setMaximumSize(new Dimension(200,30));
		dureeText.setMaximumSize(new Dimension(200,30));
		r6.add(duree);
		r6.add(dureeText);
		content.add(r6);
		
		content.add(mettre_a_jour);
		
		setContentPane(content);
	}
	
	public void action() {
		mettre_a_jour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modele.mettreAjourProjet()) {
					JOptionPane.showMessageDialog(null, "1 projet est modifier ", "Message", JOptionPane.INFORMATION_MESSAGE);
					modele.reset();
				}else {
					JOptionPane.showMessageDialog(null, "les donnees sont incorrect!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}

}
