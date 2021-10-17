package metier.gestion;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import metier.pojo.Etudiant;


public class ModeleTableEtudiantFORprofesseur extends AbstractTableModel{
	
	private ArrayList<Etudiant> listeEtudiant;
	
	public ModeleTableEtudiantFORprofesseur(ArrayList<Etudiant> listeEtudiants) {
		this.listeEtudiant = listeEtudiants; 
	}
	
	
	public void addRow(Etudiant e) {
		this.listeEtudiant.add(e);
		fireTableRowsInserted(listeEtudiant.size()-1,listeEtudiant.size()-1);
	}
	
	public void deleteRow(int indexRow) {
		this.listeEtudiant.remove(indexRow);
		fireTableRowsDeleted(indexRow, indexRow);
	}
	
	@Override
	public int getRowCount() {
		return listeEtudiant.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Etudiant e = listeEtudiant.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return e.getId_etudiant();
		case 1: 
			return e.getCNE();
		case 2: 
			return e.getNom();
		case 3: 
			return e.getPrenom();
		case 4: 
			return e.getEmail();
		case 5: 
			return e.getId_filier();
		case 6: 
			return e.getId_professeur();
		case 7: 
			return e.getId_projet();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Id_etudiant";
		case 1 : return "CNE";
		case 2 : return "Nom";
		case 3 : return "Prenom";
		case 4 : return "Email";
		case 5 : return "Id_filier";
		case 6 : return "Id_professeur";
		case 7 : return "Id_projet";
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
		case 5 : return Integer.class;
		case 6 : return Integer.class;
		case 7 : return Integer.class;
		default : return Object.class;
		}
	}

}

