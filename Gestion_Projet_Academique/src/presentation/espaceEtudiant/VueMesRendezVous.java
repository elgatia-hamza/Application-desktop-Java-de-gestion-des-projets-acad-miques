package presentation.espaceEtudiant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueDeposerUnDocument;
import metier.pojo.Etudiant;
import metier.pojo.Projet;
import persistance.DAOProjet;

import com.toedter.calendar.JCalendar;

public class VueMesRendezVous extends JFrame {
	private ModeleVueDeposerUnDocument modele1;
	private JCheckBox chckbxLivrable1;
	private JCheckBox chckbxLivrable2;
	private JCheckBox chckbxLivrable3;
	private JCheckBox chckbxRapport;
	private JLabel labelDate;
	private JTextField cloture;
	private JCalendar calendar;
	private Etudiant etudiant;
	private ControlleurVueMesRendezVous navigateur;
	private JButton ButtonAcceuil;
	private DAOProjet tableprojet;
	private Projet projet;
	
	
	
	
	
	
	
	
	
	public VueMesRendezVous(Etudiant etudiant) throws ClassNotFoundException
	{
		tableprojet = new DAOProjet();
		this.etudiant = etudiant;
		demarer();
		initialise();
		design();
		action();
	}
	
	public void demarer() {
		setTitle("Mes Rendez Vous");
		setSize(700, 500);
		setVisible(true);
	}
	public void initialise() throws ClassNotFoundException {
		projet = new Projet();
		modele1= new ModeleVueDeposerUnDocument(etudiant);
		navigateur = new ControlleurVueMesRendezVous(this);
		calendar = new JCalendar();
		chckbxLivrable1 = new JCheckBox("Livrable 1");
		chckbxLivrable2 = new JCheckBox("Livrable 2");
		chckbxLivrable3 = new JCheckBox("Livrable 3 ");
		chckbxRapport = new JCheckBox("Rapport");
		labelDate = new JLabel("date de cloture");
		ButtonAcceuil = new JButton("< Accueil");
		projet = tableprojet.searchById(etudiant.getId_projet());
		cloture = new JTextField(projet.getCloture());
	}
	public void design() {
		
		chckbxLivrable1.setBounds(500, 70, 152, 47);
		chckbxLivrable1.setEnabled(false);
		chckbxLivrable2.setBounds(500, 130, 129, 47);
		chckbxLivrable2.setEnabled(false);
		chckbxLivrable3.setBounds(500, 190, 152, 44);
		chckbxLivrable3.setEnabled(false);
		chckbxRapport.setBounds(500, 250, 152, 44);
		chckbxRapport.setEnabled(false);
		labelDate.setBounds(82, 336, 171, 28);
		ButtonAcceuil.setBounds(550, 400, 100, 25);
		calendar.setBounds(70, 70, 332, 239);
		cloture.setBounds(200, 336, 171, 28);
		
		
		
		add(chckbxLivrable1);
		add(chckbxLivrable2);
		add(chckbxLivrable3);
		add(chckbxRapport);
		add(labelDate);
		add(calendar);
		add(ButtonAcceuil);
		add(cloture);
		setLayout(null);
		
		
	}
	public void action() {
		
			ButtonAcceuil.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
				
					navigateur.executeVueAccueil(new ModeleVueAccueil(etudiant));
				}
			});
			if(!modele1.isChampsexist(etudiant.getId_etudiant(), "Livrable1",etudiant.getId_professeur())){
				chckbxLivrable1.setSelected(true);
			}
			if(!modele1.isChampsexist(etudiant.getId_etudiant(), "Livrable2",etudiant.getId_professeur())){
				chckbxLivrable2.setSelected(true);
				
			}
			if(!modele1.isChampsexist(etudiant.getId_etudiant(), "Livrable3",etudiant.getId_professeur())){
				chckbxLivrable3.setSelected(true);
				
			}
			if(!modele1.isChampsexist(etudiant.getId_etudiant(), "Rapport",etudiant.getId_professeur())){
				chckbxRapport.setSelected(true);
				
			}
		}


}
