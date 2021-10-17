package metier.gestion;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import metier.pojo.Document;
import metier.pojo.Etudiant;

public class ModeleTableDocuments  extends AbstractTableModel{

	
	private ArrayList<Document> listeDuDocument;
	
	public ModeleTableDocuments(ArrayList<Document> listeDuDocument) {
		this.listeDuDocument = listeDuDocument; 
	}
	
	
	@Override
	public int getRowCount() {
		return listeDuDocument.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Document d = listeDuDocument.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return d.getTitre();
		case 1: 
			return d.getMot_cles();
		case 2: 
			return d.getType_document();
		case 3: 
			return d.getPath();
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Titre";
		case 1 : return "Mot_cles";
		case 2 : return "Type_document";
		case 3 : return "getPath";
		
		default : return null;
		}
	}
	
	@Override
	public Class getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		
		default : return Object.class;
		}
	}

}


