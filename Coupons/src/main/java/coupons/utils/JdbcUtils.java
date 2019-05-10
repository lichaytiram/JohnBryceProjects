package coupons.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class create an utilities
 * 
 * @author Lichay
 *
 */
public class JdbcUtils {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return This class return a connection
	 * @throws SQLException Can throw a sql exception
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/coupons?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
				"root", "1232");
		return connection;
	}

	/**
	 * @param connection        Receive a connection
	 * @param preparedStatement Receive a preparedStatement
	 */
	public static void closeResources(Connection connection, PreparedStatement preparedStatement) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param connection        Receive a connection
	 * @param preparedStatement Receive a preparedStatement
	 * @param resultSet         Receive a resultSet
	 */
	public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		closeResources(connection, preparedStatement);
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param connection         Receive a connection
	 * @param preparedStatement1 Receive a preparedStatement1
	 * @param preparedStatement2 Receive a preparedStatement2
	 */
	public static void closeResources(Connection connection, PreparedStatement preparedStatement1,
			PreparedStatement preparedStatement2) {
		closeResources(connection, preparedStatement1);
		try {
			if (preparedStatement2 != null) {
				preparedStatement2.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param connection         Receive a connection
	 * @param preparedStatement1 Receive a preparedStatement1
	 * @param preparedStatement2 Receive a preparedStatement2
	 * @param preparedStatement3 Receive a preparedStatement3
	 * @param preparedStatement4 Receive a preparedStatement4
	 * @param preparedStatement5 Receive a preparedStatement5
	 */
	public static void closeResources(Connection connection, PreparedStatement preparedStatement1,
			PreparedStatement preparedStatement2, PreparedStatement preparedStatement3,
			PreparedStatement preparedStatement4, PreparedStatement preparedStatement5) {
		closeResources(connection, preparedStatement1, preparedStatement2);
		try {
			if (preparedStatement3 != null) {
				preparedStatement3.close();
			}
			if (preparedStatement4 != null) {
				preparedStatement4.close();
			}
			if (preparedStatement5 != null) {
				preparedStatement5.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}