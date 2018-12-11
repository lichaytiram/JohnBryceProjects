package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
	// don't finish yet
	// singleton ConnectionPool -->
	private static String USERNAME = "root";
	private static String PASSWORD = null;
	private final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	private Queue<Connection> connectionList = new LinkedList<>();

	private ConnectionPool() {
		try {
			for (int i = 0; i < 10; i++) {
				Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				connectionList.add(con);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

}
