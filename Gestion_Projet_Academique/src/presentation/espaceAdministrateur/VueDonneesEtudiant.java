package presentation.espaceAdministrateur;

import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueDonneesEtudiant;
import metier.pojo.Etudiant;
import persistance.DAOEtudiant;


/**
 * @author Hamza
 *
 */

public class VueDonneesEtudiant extends JFrame{
	private JTable table;
	private ModeleTableEtudiant model;
	private JTabbedPane tabbedPane;
	private DAOEtudiant listEtudiants;
	private JLabel cne1;
	private JLabel cne2;
	private JLabel cne3;
	private JLabel nom;
	private JLabel prenom;
	private JLabel email;
	private JLabel password;
	private JLabel filier;
	private JTextField cneText1;
	private JTextField cneText2;
	private JTextField cneText3;
	private JTextField nomText;
	private JTextField prenomText;
	private JTextField emailText;
	private JTextField passwordText;
	private JComboBox<String> filierlist;
	private JButton ajouter;
	private JButton recherche1;
	private JButton recherche2;
	private ModeleVueDonneesEtudiant modele;
	private ControlleurVueDonneesEtudiant nav;
	
	public VueDonneesEtudiant() throws ClassNotFoundException {
		init();
		dessin();
		action();
		demarer();
	}
	
	public void demarer() {
		setTitle("Données Etudients");
		setSize(1000, 500);
		//pack();
		//setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void init() throws ClassNotFoundException {
		listEtudiants = new DAOEtudiant();
		
		model = new ModeleTableEtudiant(listEtudiants.getAll());
		table  = new JTable(model);
		
		tabbedPane = new JTabbedPane();
		
		cne1 = new JLabel("CNE");
		cne1.setMaximumSize(new Dimension(100,20));
		cne2 = new JLabel("CNE");
		cne2.setMaximumSize(new Dimension(200,20));
		cne3 = new JLabel("CNE");
		cne3.setMaximumSize(new Dimension(200,20));
		nom = new JLabel("Nom");
		nom.setMaximumSize(new Dimension(100,20));
		prenom = new JLabel("Prenom");
		prenom.setMaximumSize(new Dimension(100,20));
		email = new JLabel("Email");
		email.setMaximumSize(new Dimension(100,20));
		password = new JLabel("Password");
		password.setMaximumSize(new Dimension(100,20));
		filier = new JLabel("Filier");
		filier.setMaximumSize(new Dimension(100,20));
		
		cneText1 = new JTextField();
		cneText1.setMaximumSize(new Dimension(200,30));
		cneText2 = new JTextField();
		cneText2.setMaximumSize(new Dimension(300,30));
		cneText3 = new JTextField();
		cneText3.setMaximumSize(new Dimension(300,30));
		nomText = new JTextField();
		nomText.setMaximumSize(new Dimension(200,30));
		prenomText = new JTextField();
		prenomText.setMaximumSize(new Dimension(200,30));
		emailText = new JTextField();
		emailText.setMaximumSize(new Dimension(200,30));
		passwordText = new JTextField();
		passwordText.setMaximumSize(new Dimension(200,30));
		
		Object[] elements = new Object[]{"IID", "GI", "GE", "GRT", "GP","BIG DATA"}; 
		filierlist = new JComboBox(elements);
		filierlist.setMaximumSize(new Dimension(200,30));
		
		ajouter = new JButton("Ajouter");
		recherche1 = new JButton("Recherche");
		recherche2 = new JButton("Recherche");
		
		modele = new ModeleVueDonneesEtudiant(model, cneText1, nomText, prenomText, emailText, passwordText, filierlist);
		nav = new ControlleurVueDonneesEtudiant(this);
	}
	
	public void dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.X_AXIS));
		
		//table.setGridColor(new Color(255,255,255));
		table.setRowHeight(15);
		//table.getColumn(4).setMinWidth(100);
		//table.setBackground(new Color(0,255,255));
		table.setFont(new Font("Segoe UI", 1, 12));
		//table.setForeground(new Color(255,255,255));
		
		JScrollPane s = new JScrollPane(table);
		s.setBorder(BorderFactory.createTitledBorder("Liste des etudiants"));
		//s.setPreferredSize(new Dimension(800,400));
		//s.setPreferredSize(table.getPreferredSize());
		content.add(s);
		
		JPanel panel1 = new JPanel();
		/*panel1.setLayout(new GridLayout(6,2));
		panel1.add(cne);
		panel1.add(cneText);
		panel1.add(nom);
		panel1.add(nomText);
		panel1.add(prenom);
		panel1.add(prenomText);
		panel1.add(email);
		panel1.add(emailText);
		panel1.add(password);
		panel1.add(passwordText);
		panel1.add(filier);
		panel1.add(filierlist);
		panel1.setPreferredSize(new Dimension(200,30));*/
		
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
		
		JPanel r1 = new JPanel();
		r1.setLayout(new BoxLayout(r1,BoxLayout.X_AXIS));
		r1.add(cne1);
		r1.add(cneText1);
		panel1.add(r1);
		
		JPanel r2 = new JPanel();
		r2.setLayout(new BoxLayout(r2,BoxLayout.X_AXIS));
		r2.add(nom);
		r2.add(nomText);
		panel1.add(r2);
		
		JPanel r3 = new JPanel();
		r3.setLayout(new BoxLayout(r3,BoxLayout.X_AXIS));
		r3.add(prenom);
		r3.add(prenomText);
		panel1.add(r3);
		
		JPanel r4 = new JPanel();
		r4.setLayout(new BoxLayout(r4,BoxLayout.X_AXIS));
		r4.add(email);
		r4.add(emailText);
		panel1.add(r4);
		
		JPanel r5 = new JPanel();
		r5.setLayout(new BoxLayout(r5,BoxLayout.X_AXIS));
		r5.add(password);
		r5.add(passwordText);
		panel1.add(r5);
		
		JPanel r6 = new JPanel();
		r6.setLayout(new BoxLayout(r6,BoxLayout.X_AXIS));
		r6.add(filier);
		r6.add(filierlist);
		panel1.add(r6);
		
		panel1.add(ajouter);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		JPanel rowp2 =  new JPanel();
		rowp2.setLayout(new BoxLayout(rowp2,BoxLayout.X_AXIS));
		rowp2.add(cne2);
		rowp2.add(cneText2);
		panel2.add(rowp2);
		panel2.add(recherche1);
		JPanel row2p2 =  new JPanel();
		row2p2.setLayout(new BoxLayout(row2p2,BoxLayout.X_AXIS));
		row2p2.add(recherche1);
		panel2.add(row2p2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
		JPanel rowp3 =  new JPanel();
		rowp3.setLayout(new BoxLayout(rowp3,BoxLayout.X_AXIS));
		rowp3.add(cne3);
		rowp3.add(cneText3);
		panel3.add(rowp3);
		JPanel row2p3 =  new JPanel();
		row2p3.setLayout(new BoxLayout(row2p3,BoxLayout.X_AXIS));
		row2p3.add(recherche2);
		panel3.add(row2p3);
		
		
		tabbedPane.addTab("Ajouter", panel1);
		tabbedPane.addTab("Modifier", panel2);
		tabbedPane.addTab("Supprimer", panel3);
		
		content.add(tabbedPane);
		
		setContentPane(content);
	}
	
	public void action() {
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modele.add()) {
					JOptionPane.showMessageDialog(null, "1 etudiant est ajouter ", "Message", JOptionPane.INFORMATION_MESSAGE);
					modele.reset();
				}else {
					JOptionPane.showMessageDialog(null, "les donnees sont incorrect!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		recherche1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Etudiant etudiant = modele.searchByCne(cneText2);
				if(etudiant!=null){
					nav.executeVueNouvelleDonneeEtudiant(etudiant, model);
				}else{
					JOptionPane.showMessageDialog(null, "CNE n'exist pas!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		recherche2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Etudiant etudiant = modele.searchByCne(cneText3);
				if(etudiant!=null) {
					int choix = JOptionPane.showConfirmDialog(null, "Voullez-vous vraiment supprimer ce etudiant? " , "Supprimer...", JOptionPane.YES_NO_CANCEL_OPTION);
					if(choix == 0) {
						modele.supprimeEtudiant(etudiant);
					}
				}else {
					JOptionPane.showMessageDialog(null, "CNE est n'exist pas!", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}