package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {

	private final static String USERNAME = "root";
	private final static String PASSWORD = null;
	private final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final int size;
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
		size = connectionList.size();
	}

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

	public Connection getConnection() throws InterruptedException {

		synchronized (connectionList) {
			if (connectionList.isEmpty())
				connectionList.wait();
			return connectionList.poll();
		}
	}

	public void restoreConnection(Connection connection) {
		synchronized (connectionList) {
			connectionList.add(connection);
			connectionList.notify();
		}
	}

	public void closeAllConnection() throws SQLException, InterruptedException {
		synchronized (connectionList) {
			while (connectionList.size() < size)
				connectionList.wait();
			for (Connection connection : connectionList)
				connection.close();
//			for (int i = 0; i < connectionList.size(); i++) {
//				connectionList.peek().close();
//			}

		}
	}
}
