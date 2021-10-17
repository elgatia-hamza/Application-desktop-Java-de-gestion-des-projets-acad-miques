package presentation.espaceEtudiant;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.gestion.ModeleTableDocuments;
import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueDeposerUnDocument;
import metier.pojo.Etudiant;
import persistance.DAODocument;

public class VueConsulterLesDocumentsDeMonProjet extends JFrame{
	private JTextField rechercheParMotCle;
	private JButton reteur;
	private ModeleTableDocuments table;
	private JTable tableDocuments;
	private DAODocument listeDocuments;
	private JButton valide;
	private Etudiant etudiant;
	private ControlleurVueConsulterLesDocuments navigateur;

	
	public VueConsulterLesDocumentsDeMonProjet(Etudiant etudiant) throws ClassNotFoundException {
		this.etudiant = etudiant;
		demarer();
		initialise();
		design();
		Action();
	}
	


	public void demarer(){
		setTitle("Consulter Les Documents De Mon Projet");
		setVisible(true);
		setSize(700, 500);
	}
	public void initialise() throws ClassNotFoundException {
		navigateur = new ControlleurVueConsulterLesDocuments(this);
		listeDocuments = new DAODocument();
		table = new ModeleTableDocuments(listeDocuments.searchDocument(etudiant.getId_etudiant(), etudiant.getId_professeur()));

		tableDocuments = new JTable(table);
		tableDocuments.setRowHeight(15);
		tableDocuments.setFont(new Font("Segoe UI", 1, 12));
		
		reteur = new JButton("< reteur");
		rechercheParMotCle = new JTextField();
		valide = new JButton("valide");
	
	}
	public void design() {
		reteur.setBounds(50, 400, 100, 25);
		/*rechercheParMotCle.setText("entrer un mot cle");
		rechercheParMotCle.setBounds(200, 150, 300, 30);
		valide.setBounds(200, 200, 100, 25);
		add(rechercheParMotCle);*/
		
		JScrollPane s = new JScrollPane(tableDocuments);
		s.setBorder(BorderFactory.createTitledBorder("Liste des documents"));
		s.setBounds(50, 10,500, 300);
		add(s);
		add(reteur);
		add(valide);
		setLayout(null);
	}
	public void Action() {
		reteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigateur.reteur(etudiant);				
			}
		});
		
	}
	
	
	
	
	
	
	
	
	
	

}
