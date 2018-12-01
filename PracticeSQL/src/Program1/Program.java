package Program1;

import java.sql.*;

public class Program {
	private static String USERNAME = null;
	private static String PASSWORD = null;
	private static String URL = "jdbc:mysql://localhost:3306";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			create();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		con.createStatement().executeUpdate("CREATE TABLE IF NOT EXSIST person" + "(lable int auto_increment not null,"
				+ "name varchar(10) not null," + "id int(9) not null," + "age int(3) default null," + "lable primary");
		System.out.println("table is succeed");
	}

}
