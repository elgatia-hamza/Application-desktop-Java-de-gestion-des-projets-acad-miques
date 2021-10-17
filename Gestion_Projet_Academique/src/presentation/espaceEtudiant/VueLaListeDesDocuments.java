package presentation.espaceEtudiant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueAccueil;
import metier.gestion.ModeleVueAuthentification;
import metier.gestion.ModeleVueDeposerUnDocument;
import metier.pojo.Etudiant;
import presentation.espaceEtudiant.ControlleurVueLaListeDesDocuments;;

public class VueLaListeDesDocuments extends JFrame{
	
	private Etudiant etudiant;
	private JButton deposeUnDocument;
	private JButton Consulter;
	private JButton ButtonAcceuil;
	private ControlleurVueLaListeDesDocuments navi;
	private ModeleVueAuthentification modele;
	
	
	public VueLaListeDesDocuments(Etudiant etudiant) {
		this.etudiant = etudiant;
		demarer();
		initialise();
		design();
		Action();
	}
	public void demarer() {
		setTitle("La Liste Des Documents");
		setSize(700, 500);
		setVisible(true);
	}
	public void initialise() {
		navi = new ControlleurVueLaListeDesDocuments(this);
		deposeUnDocument = new JButton("deposer un document");
		Consulter = new JButton("Consulter les documents de mon projet");
		ButtonAcceuil = new JButton("< Accueil");
	}
	public void design() {
		deposeUnDocument.setBounds(225, 200, 250, 30);
		Consulter.setBounds(200, 250, 300, 30);
		ButtonAcceuil.setBounds(550, 400, 100, 25);
		add(Consulter);
		add(deposeUnDocument);
		add(ButtonAcceuil);
		setLayout(null);
	}

	public void Action() {
		deposeUnDocument.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					navi.executeVueDeposerUnDocument(new ModeleVueDeposerUnDocument(etudiant));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		Consulter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navi.executeVueConsulterLesDocumentsDeMonProjet(etudiant);
			}
		});
		ButtonAcceuil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				navi.executeVueAccueil(new ModeleVueAccueil(etudiant));
			}
		});
	}
	public ControlleurVueLaListeDesDocuments getNavi() {
		return navi;
	}
	public void setNavi(ControlleurVueLaListeDesDocuments navi) {
		this.navi = navi;
	}
}
