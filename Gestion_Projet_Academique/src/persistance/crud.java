package persistance;

import java.util.ArrayList;


/**
 * @author Hamza
 *
 */


public interface crud <Table>{
	boolean add (Table table);
	boolean delete(Table table);
	boolean isExiste(Table table);
	Table searchById(int id);
	ArrayList<Table> getAll();
	boolean update(int id,Table table);
}
