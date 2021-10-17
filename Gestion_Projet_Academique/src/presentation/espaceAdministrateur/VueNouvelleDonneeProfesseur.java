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

import metier.gestion.ModeleTableProfesseur;
import metier.gestion.ModeleVueDonneesProfesseur;
import metier.pojo.Professeur;



/**
 * @author Hamza
 *
 */

public class VueNouvelleDonneeProfesseur extends JFrame{
	private JLabel id;
	private JLabel id_departement;
	private JLabel nom;
	private JLabel prenom;
	private JLabel email;
	private JLabel password;
	private JLabel domaine_recherche;
	private JTextField idText;
	private JTextField id_departementText;
	private JTextField nomText;
	private JTextField prenomText;
	private JTextField emailText;
	private JTextField passwordText;
	private JComboBox<String> domaine_recherche_list;
	private JButton mettreAjour;
	private Professeur professeur;
	private ModeleTableProfesseur tableProfesseur;
	private ModeleVueDonneesProfesseur modele;

	public VueNouvelleDonneeProfesseur(Professeur professeur, ModeleTableProfesseur tableProfesseur) throws ClassNotFoundException{
		this.professeur = professeur;
		this.tableProfesseur = tableProfesseur;
		init();
		dessin();
		action();
		demarer();
	}
	
	public void demarer() {
		setTitle("Nouvelle donnees");
		setSize(700, 500);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void init() throws ClassNotFoundException {
		id = new JLabel("Id Professeur");
		id.setMaximumSize(new Dimension(200,20));
		nom = new JLabel("Nom");
		nom.setMaximumSize(new Dimension(200,20));
		prenom = new JLabel("Prenom");
		prenom.setMaximumSize(new Dimension(200,20));
		email = new JLabel("Email");
		email.setMaximumSize(new Dimension(200,20));
		password = new JLabel("Password");
		password.setMaximumSize(new Dimension(200,20));
		domaine_recherche = new JLabel("Domaine Recherche");
		domaine_recherche.setMaximumSize(new Dimension(200,20));
		id_departement = new JLabel("Id Departement");
		id_departement.setMaximumSize(new Dimension(200,20));
		
		idText = new JTextField(professeur.getId_professeur());
		idText.setMaximumSize(new Dimension(200,30));
		id_departementText = new JTextField(professeur.getId_departement());
		id_departementText.setMaximumSize(new Dimension(200,30));
		nomText = new JTextField(professeur.getNom());
		nomText.setMaximumSize(new Dimension(200,30));
		prenomText = new JTextField(professeur.getPrenom());
		prenomText.setMaximumSize(new Dimension(200,30));
		emailText = new JTextField(professeur.getEmail());
		emailText.setMaximumSize(new Dimension(200,30));
		passwordText = new JTextField(professeur.getPassword());
		passwordText.setMaximumSize(new Dimension(200,30));
		
		Object[] elements = new Object[]{"Mathématique", "Securité", "BlockChaine", "Statistique", "Electronique","Artificeil Intelligence"}; 
		domaine_recherche_list = new JComboBox(elements);
		domaine_recherche_list.setMaximumSize(new Dimension(200,30));
		
		mettreAjour = new JButton("Mettre a jour");
		
		modele = new ModeleVueDonneesProfesseur(tableProfesseur, idText, id_departementText, nomText, prenomText, emailText, passwordText, domaine_recherche_list);
		
	}
	
	public void  dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createTitledBorder("Enter nouvelles données"));
		
		JPanel r1 = new JPanel();
		r1.setLayout(new BoxLayout(r1,BoxLayout.X_AXIS));
		r1.add(id);
		r1.add(idText);
		content.add(r1);
		
		JPanel r2 = new JPanel();
		r2.setLayout(new BoxLayout(r2,BoxLayout.X_AXIS));
		r2.add(nom);
		r2.add(nomText);
		content.add(r2);
		
		JPanel r3 = new JPanel();
		r3.setLayout(new BoxLayout(r3,BoxLayout.X_AXIS));
		r3.add(prenom);
		r3.add(prenomText);
		content.add(r3);
		
		JPanel r4 = new JPanel();
		r4.setLayout(new BoxLayout(r4,BoxLayout.X_AXIS));
		r4.add(email);
		r4.add(emailText);
		content.add(r4);
		
		JPanel r5 = new JPanel();
		r5.setLayout(new BoxLayout(r5,BoxLayout.X_AXIS));
		r5.add(password);
		r5.add(passwordText);
		content.add(r5);
		
		JPanel r6 = new JPanel();
		r6.setLayout(new BoxLayout(r6,BoxLayout.X_AXIS));
		r6.add(domaine_recherche);
		r6.add(domaine_recherche_list);
		content.add(r6);
		
		JPanel r7 = new JPanel();
		r7.setLayout(new BoxLayout(r7,BoxLayout.X_AXIS));
		r7.add(id_departement);
		r7.add(id_departementText);
		content.add(r7);
		
		content.add(mettreAjour);
		
		setContentPane(content);
	}
	
	public void action() {
		mettreAjour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modele.mettreAjourProfesseur(professeur.getId_professeur())) {
					JOptionPane.showMessageDialog(null, "1 professeur est modifier ", "Message", JOptionPane.INFORMATION_MESSAGE);
					modele.reset();
				}else {
					JOptionPane.showMessageDialog(null, "les donnees sont incorrect!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
	}

}
