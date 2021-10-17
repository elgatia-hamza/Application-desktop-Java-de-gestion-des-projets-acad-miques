package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Hamza
 *
 */

public class ConnexionBD {
	private String URL = "jdbc:mysql://localhost/projet";
	private String Login = "root";
	private String Password = "";

	private static Connection connect;

	public ConnexionBD() throws ClassNotFoundException  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			connect = DriverManager.getConnection(URL, Login, Password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() throws ClassNotFoundException {
		if (connect == null) {
			new ConnexionBD();
			
		}
		return connect;
	}
}