package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root",
				null);
		return connection;
	}

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