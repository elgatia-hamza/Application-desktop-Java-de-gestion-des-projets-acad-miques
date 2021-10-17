package metier.gestion;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import metier.pojo.Projet;

public class ModeleTableProjet extends AbstractTableModel{
	private ArrayList<Projet> listeProjets;
	public ModeleTableProjet(ArrayList<Projet> listeProjets) {
		this.listeProjets = listeProjets; 
	}
	
	public void addRow(Projet p) {
		this.listeProjets.add(p);
		fireTableRowsInserted(listeProjets.size()-1,listeProjets.size()-1);
	}
	
	public void deleteRow(int indexRow) {
		this.listeProjets.remove(indexRow-1);
		fireTableRowsDeleted(indexRow-1, indexRow-1);
	}
	
	@Override
	public int getRowCount() {
		return listeProjets.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Projet p = listeProjets.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return p.getId_projet();
		case 1: 
			return p.getTheme_projet();
		case 2: 
			return p.getType();
		case 3: 
			return p.getCloture();
		case 4: 
			return p.getDuree();
		case 5: 
			return p.getEtat_avencement();
		case 6: 
			return (p.getRapport()==1)?true:false;
		case 7: 
			return p.getId_professeur();
		case 8: 
			return p.getId_administrateur();
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Id Projet";
		case 1 : return "Theme Projet";
		case 2 : return "Type";
		case 3 : return "Cloture";
		case 4 : return "Duree";
		case 5 : return "Etat Avencement";
		case 6 : return "Rapport";
		case 7 : return "Id Professeur";
		case 8 : return "Id Administrateur";
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
		case 6 : return Boolean.class;
		case 7 : return Integer.class;
		case 8 : return Integer.class;
		default : return Object.class;
		}
	}
}
