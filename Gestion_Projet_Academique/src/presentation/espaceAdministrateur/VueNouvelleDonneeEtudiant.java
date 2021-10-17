package presentation.espaceAdministrateur;

import java.awt.Component;
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

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueDonneesEtudiant;
import metier.pojo.Etudiant;


/**
 * @author Hamza
 *
 */


public class VueNouvelleDonneeEtudiant  extends JFrame{
	private JLabel cne;
	private JLabel nom;
	private JLabel prenom;
	private JLabel email;
	private JLabel password;
	private JLabel filier;
	private JTextField cneText;
	private JTextField nomText;
	private JTextField prenomText;
	private JTextField emailText;
	private JTextField passwordText;
	private JComboBox<String> filierlist;
	private JButton mettreAjour;
	private ModeleVueDonneesEtudiant modele;
	private ModeleTableEtudiant tableEtudiant;
	private Etudiant etudiant;

	public VueNouvelleDonneeEtudiant(Etudiant etudiant,ModeleTableEtudiant tableEtudiant) throws ClassNotFoundException{
		this.etudiant = etudiant;
		this.tableEtudiant = tableEtudiant;
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
		cne = new JLabel("CNE");
		cne.setMaximumSize(new Dimension(200,20));
		nom = new JLabel("Nom");
		nom.setMaximumSize(new Dimension(200,20));
		prenom = new JLabel("Prenom");
		prenom.setMaximumSize(new Dimension(200,20));
		email = new JLabel("Email");
		email.setMaximumSize(new Dimension(200,20));
		password = new JLabel("Password");
		password.setMaximumSize(new Dimension(200,20));
		filier = new JLabel("Filier");
		filier.setMaximumSize(new Dimension(200,20));
		
		cneText = new JTextField(etudiant.getCNE());
		cneText.setMaximumSize(new Dimension(200,30));
		nomText = new JTextField(etudiant.getNom());
		nomText.setMaximumSize(new Dimension(200,30));
		prenomText = new JTextField(etudiant.getPrenom());
		prenomText.setMaximumSize(new Dimension(200,30));
		emailText = new JTextField(etudiant.getEmail());
		emailText.setMaximumSize(new Dimension(200,30));
		passwordText = new JTextField(etudiant.getPassword());
		passwordText.setMaximumSize(new Dimension(200,30));
		
		Object[] elements = new Object[]{"IID", "GI", "GE", "GRT", "GP","BIG DATA"}; 
		filierlist = new JComboBox(elements);
		filierlist.setMaximumSize(new Dimension(200,30));
		filierlist.setSelectedIndex(etudiant.getId_filier()-1);
		
		mettreAjour = new JButton("Mettre a jour");
		
		modele = new ModeleVueDonneesEtudiant(tableEtudiant, cneText, nomText, prenomText, emailText, passwordText, filierlist);
	}
	
	public void  dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createTitledBorder("Enter nouvelles données"));
		
		JPanel r1 = new JPanel();
		r1.setLayout(new BoxLayout(r1,BoxLayout.X_AXIS));
		r1.add(cne);
		r1.add(cneText);
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
		r6.add(filier);
		r6.add(filierlist);
		content.add(r6);
		
		content.add(mettreAjour);
		
		setContentPane(content);
	}
	
	public void action() {
		mettreAjour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modele.mettreAjourEtudiant(etudiant.getId_etudiant())) {
					JOptionPane.showMessageDialog(null, "1 etudiant est modifier ", "Message", JOptionPane.INFORMATION_MESSAGE);
					modele.reset();
				}else {
					JOptionPane.showMessageDialog(null, "les donnees sont incorrect!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
	}
}
