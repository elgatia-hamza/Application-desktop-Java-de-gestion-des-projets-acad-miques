package presentation_espaceProfesseur;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class VueConsulationRapport2 extends JFrame {
	
	private JButton ButtonConsulter;
    private  JTable EtudiantTable;
    private JLabel lebelLienRpprt;
    private JButton validebutton;
    private JScrollPane scrollTable;
    private JLabel path;
    
	public VueConsulationRapport2() {
		super("VueConsulationRapport2");
		initialiser();
		dessiner();
		
	}
    
	public JButton getButtonConsulter() {
		return ButtonConsulter;
	}

	public void setButtonConsulter(JButton buttonConsulter) {
		ButtonConsulter = buttonConsulter;
	}

	public JTable getEtudiantTable() {
		return EtudiantTable;
	}

	public void setEtudiantTable(JTable etudiantTable) {
		EtudiantTable = etudiantTable;
	}

	public JLabel getLebelLienRpprt() {
		return lebelLienRpprt;
	}

	public void setLebelLienRpprt(JLabel lebelLienRpprt) {
		this.lebelLienRpprt = lebelLienRpprt;
	}

	public JButton getValidebutton() {
		return validebutton;
	}

	public void setValidebutton(JButton validebutton) {
		this.validebutton = validebutton;
	}


	private void dessiner() {
		setLayout(null);
		ButtonConsulter.setBounds(241, 298, 154, 23);
		 add(ButtonConsulter);
		 scrollTable.setBounds(10, 11, 600, 218);
		lebelLienRpprt.setBounds(10, 373, 596, 14);
		add(lebelLienRpprt);
		validebutton.setBounds(520, 463, 89, 23);
		EtudiantTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		add(scrollTable);
		add(validebutton);
		path.setBounds(170, 409, 596, 14);
		add(path);
		setSize(700,600);
		setResizable(false);
		
	}
	private void initialiser() {
		ButtonConsulter = new JButton("consulter le rapport");
		EtudiantTable = new JTable();
		scrollTable = new JScrollPane( EtudiantTable);
		lebelLienRpprt = new JLabel("lien de rapport : ");
		validebutton = new JButton("Valider");
		path=new JLabel();
	}

	public JLabel getPath() {
		return path;
	}

	public void setPath(JLabel path) {
		this.path = path;
	}


}