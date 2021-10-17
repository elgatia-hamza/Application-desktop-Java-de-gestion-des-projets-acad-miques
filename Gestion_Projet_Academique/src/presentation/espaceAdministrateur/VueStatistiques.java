package presentation.espaceAdministrateur;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import metier.gestion.ModeleVueDonneesProjets;



/**
 * @author Hamza
 *
 */


public class VueStatistiques extends JFrame{
	private JLabel etat_davencement;
	private JProgressBar progresse_bar;
	private HistogramPanel histograme;
	private ModeleVueDonneesProjets modele;
	
	public VueStatistiques(ModeleVueDonneesProjets modele) {
		this.modele = modele;
		init();
		dessin();
		action();
		demarer();
	}
	
	public void demarer() {
		setTitle("Statistiques d'avancement");
		setSize(500,500);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	
	public void init() {
		etat_davencement = new JLabel("Etat d'avencement");
		etat_davencement.setMaximumSize(new Dimension(300, 20));
		
		progresse_bar = new JProgressBar();
		progresse_bar.setValue((int)modele.getAvencementTotal());
		progresse_bar.setStringPainted(true);
		progresse_bar.setMaximumSize(new Dimension(300, 30));
		
		histograme = new HistogramPanel();
		histograme.addHistogramColumn("IID", 10*modele.getAvencementIID(), Color.RED);
		histograme.addHistogramColumn("GI", 10*modele.getAvencementGI(), Color.YELLOW);
		histograme.addHistogramColumn("GRT", 510, Color.BLUE);
		histograme.addHistogramColumn("GE", 10*modele.getAvencementGE(), Color.ORANGE);
		histograme.addHistogramColumn("GPE", 180, Color.MAGENTA);
		histograme.addHistogramColumn("BIG DATA", 504, Color.CYAN);
		histograme.layoutHistogram();
		histograme.setMaximumSize(new Dimension(500, 500));
		
	}
	
	public void dessin() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		panel.add(etat_davencement);
		panel.add(progresse_bar);
		panel.setBorder(BorderFactory.createTitledBorder("Tout les projets"));
		content.add(panel);
		
		histograme.setBorder(BorderFactory.createTitledBorder("Par type de projet"));
		content.add(histograme);
		
		setContentPane(content);		
	}
	
	public void action(){
		
	}
	
}
