package metier.gestion;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import metier.pojo.Professeur;

public class ModeleTableProfesseur extends AbstractTableModel {

	private ArrayList<Professeur> listeProfesseur;
	
	public ModeleTableProfesseur(ArrayList<Professeur> listeProfesseurs) {
		this.listeProfesseur = listeProfesseurs; 
	}
	
	
	public void addRow(Professeur p) {
		this.listeProfesseur.add(p);
		fireTableRowsInserted(listeProfesseur.size()-1,listeProfesseur.size()-1);
	}
	
	public void deleteRow(int indexRow) {
		this.listeProfesseur.remove(indexRow);
		fireTableRowsDeleted(indexRow, indexRow);
	}
	
	@Override
	public int getRowCount() {
		return listeProfesseur.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Professeur p = listeProfesseur.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return p.getId_professeur();
		case 1: 
			return p.getNom();
		case 2: 
			return p.getPrenom();
		case 3: 
			return p.getEmail();
		case 4: 
			return p.getLogin();
		case 5: 
			return p.getPassword();
		case 6: 
			return p.getDomaine_recherche();
		case 7: 
			return p.getId_departement();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Id_professeur";
		case 1 : return "Nom";
		case 2 : return "Prenom";
		case 3 : return "Email";
		case 4 : return "Login";
		case 5 : return "Password";
		case 6 : return "Domaine de recherche";
		case 7 : return "Id_departement";
		default : return null;
		}
	}
	
	@Override
	public Class getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
		case 5 : return String.class;
		case 6 : return String.class;
		case 7 : return Integer.class;
		default : return Object.class;
		}
	}


}
