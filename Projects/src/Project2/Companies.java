package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Companies {

	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS companies (ID INT(255) NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL,EMAIL VARCHAR(25) NOT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
		System.out.println("The table Companies has created");
	}

	public static void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE companies");
		System.out.println("The table is a drop");
	}

	public static void insert(String name, String email, String password) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("INSERT INTO companies (NAME,EMAIL,PASSWORD) VALUES('" + name + "','"
				+ email + "','" + password + "')");
		System.out.println("insert has done");
	}

	public static void delete(int indexToDelete) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DELETE FROM companies WHERE ID=" + indexToDelete);
		System.out.println("delete has done");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies");
		while (re.next())
			System.out.println("ID: " + re.getInt("ID") + " ,NAME: " + re.getString("NAME") + " ,EMAIL: "
					+ re.getString("EMAIL") + " ,PASSWORD:" + re.getString("PASSWORD"));
	}

	public static void update(String name, String email, String passWord, int index) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("UPDATE companies SET NAME='" + name + "', EMAIL='" + email
				+ "', PASSWORD='" + passWord + "' WHERE ID=" + index);
		System.out.println("update has done");
	}
}
