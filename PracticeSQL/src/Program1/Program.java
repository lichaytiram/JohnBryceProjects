package Program1;

import java.sql.*;

public class Program {
	private static String USERNAME = "root";
	private static String PASSWORD = null;

	private static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			create();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		con.createStatement()
				.executeUpdate("CREATE TABLE IF NOT EXISTS de" + "(lable int(5) not null auto_increment,"
						+ "name varchar(10) not null," + "id int(9) not null," + "age int(3) default null,"
						+ "primary key(lable))");
		System.out.println("table is succeed");
	}

}
