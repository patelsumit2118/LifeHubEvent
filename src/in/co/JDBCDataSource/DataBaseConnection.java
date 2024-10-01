package in.co.JDBCDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/LIFEHUBEVENT";

	private static final String USER = "root";

	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException {

		Connection connection = null;

		try {
			Class.forName(DRIVER);
		
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

}
