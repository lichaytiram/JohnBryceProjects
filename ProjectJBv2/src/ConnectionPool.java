

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class create a basic connections for all classes DBDAO
 * 
 * @author Lichay
 *
 */
public class ConnectionPool {

	private final static String USERNAME = "root";
	private final static String PASSWORD = null;
	private final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final int size;
	private Queue<Connection> connectionList = new LinkedList<>();

	/**
	 * constructor create a connection list ( with 10 connections )
	 */
	private ConnectionPool() {
		try {
			for (int i = 0; i < 10; i++) {
//				if (2 == 3) {
				Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				connectionList.add(con);
//				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		size = connectionList.size();
	}

	private static ConnectionPool instance = new ConnectionPool();

	/**
	 * @return This function return the instance for this connection pool class
	 */
	public static ConnectionPool getInstance() {
		return instance;
	}

	/**
	 * @return This function return the first connection on list
	 * @throws InterruptedException Can throw an InterruptedException
	 */
	public Connection getConnection() throws InterruptedException {

		synchronized (connectionList) {
			if (connectionList.isEmpty())
				connectionList.wait();
			return connectionList.poll();
		}
	}

	/**
	 * @param connection Receive a connection and add to connectionList connection
	 */
	public void restoreConnection(Connection connection) {
		synchronized (connectionList) {
			connectionList.add(connection);
			connectionList.notify();
		}
	}

	/**
	 * @throws SQLException         Can throw a SQLException
	 * @throws InterruptedException Can throw an InterruptedException
	 */
	public void closeAllConnection() throws SQLException, InterruptedException {
		synchronized (connectionList) {
			while (connectionList.size() < size)
				connectionList.wait();
			for (Connection connection : connectionList)
				connection.close();
		}
	}
}
