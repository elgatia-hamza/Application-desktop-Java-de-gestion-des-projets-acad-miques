package metier.gestion;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import metier.pojo.Etudiant;
import persistance.DAOEtudiant;

public class ModeleVueDonneesEtudiant {
	private JTextField cneText;
	private JTextField nomText;
	private JTextField prenomText;
	private JTextField emailText;
	private JTextField passwordText;
	private JComboBox<String> filierlist;
	private ModeleTableEtudiant modeleTable;
	private DAOEtudiant tableEtudiant;
	

	public ModeleVueDonneesEtudiant() {
		super();
	}

	public ModeleVueDonneesEtudiant(ModeleTableEtudiant modele, JTextField cneText, JTextField nomText,
			JTextField prenomText, JTextField emailText, JTextField passwordText, JComboBox<String> filierlist) throws ClassNotFoundException {
		super();
		this.cneText = cneText;
		this.nomText = nomText;
		this.prenomText = prenomText;
		this.emailText = emailText;
		this.passwordText = passwordText;
		this.filierlist = filierlist;
		tableEtudiant = new DAOEtudiant();
		modeleTable = modele;
	}
	
	public boolean add() {
		if(!champsValide(cneText)) {
			return false;
		}	
		Etudiant e = new Etudiant();
		e.setId_etudiant(modeleTable.getRowCount()+1);
		e.setCNE(cneText.getText());
		e.setNom(nomText.getText());
		e.setPrenom(prenomText.getText());
		e.setEmail(emailText.getText());
		e.setLogin(nomText.getText());
		e.setPassword(passwordText.getText());
		e.setId_filier(filierlist.getSelectedIndex()+1);
		e.setId_professeur(null);
		e.setId_projet(null);
		e.setId_professeur(null);
		e.setId_projet(null);
		
		modeleTable.addRow(e);
		tableEtudiant.add(e);
		return true;
	}
	
	public boolean champsValide(JTextField cneText){
		if(isChampVide())
			return false;
		
		if(!isCneValide(cneText))
			return false;	
		
		return true;
	}
	
	public boolean isChampVide() {
		String[] champs = new String[] {
			cneText.getText(),
			nomText.getText(),
			prenomText.getText(),
			emailText.getText(),
			passwordText.getText(),
		};
		
		for (String c : champs) {
			if(c.isEmpty())
				return true;
		}
		return false;
	}
	
	public void reset() {
		JTextField[] champs = new JTextField[] {
				cneText,
				nomText,
				prenomText,
				emailText,
				passwordText,
			};
		for (JTextField c : champs) {
				c.setText("");
		}
		
		filierlist.setSelectedIndex(0);
	}
	
	public boolean isCneValide(JTextField cneText) {
		String cne = cneText.getText();
		
		if(!cne.matches("[A-Z]([0-9]{9})"))
			return false;
		
		return true;
	}
	
	/*public boolean isEmailValide() {
		String email = emailText.getText();
		
		if(email.matches("*@*.[a-z]{3}"))
			return true;
			
		return false;
	}*/
	
	public Etudiant searchByCne(JTextField cneText) {
		String cne = cneText.getText();
		ArrayList<Etudiant> listEtudiants = tableEtudiant.getAll();
		for (Etudiant etudiant : listEtudiants) {
			if(cne.equals(etudiant.getCNE()))
				return etudiant;
		}
		
		return null;
	}
	
	public boolean mettreAjourEtudiant(int id) {
		if(!champsValide(cneText))
			return false;
		
		Etudiant e = new Etudiant();
		e.setId_etudiant(modeleTable.getRowCount());
		e.setCNE(cneText.getText());
		e.setNom(nomText.getText());
		e.setPrenom(prenomText.getText());
		e.setEmail(emailText.getText());
		e.setLogin(nomText.getText());
		e.setPassword(passwordText.getText());
		e.setId_filier(filierlist.getSelectedIndex()+1);
		e.setId_professeur(null);
		e.setId_projet(null);
		e.setId_professeur(null);
		e.setId_projet(null);
		
		if(tableEtudiant.update(id, e)!=true)
			return false;
		
		int index=0;
		while(index<modeleTable.getRowCount()) {
			if((int)modeleTable.getValueAt(index, 0)==id)
				break;
			index++;
		}
		
		
		modeleTable.deleteRow(index);
		modeleTable.addRow(e);
		
		return true;
	}
	
	public boolean supprimeEtudiant(Etudiant etudiant) {
		int id_etudiant = etudiant.getId_etudiant();
		
		int index=0;
		while(index<modeleTable.getRowCount()) {
			if((int)modeleTable.getValueAt(index, 0)==id_etudiant)
				break;
			index++;
		}
		modeleTable.deleteRow(index);
		return tableEtudiant.delete(etudiant);
	}
	

}
