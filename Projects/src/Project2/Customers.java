package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customers implements ICustomersDAO {
	public void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS customers (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,FIRST_NAME VARCHAR(10) NOT NULL,lAST_NAME VARCHAR(10) DEFAULT NULL,EMAIL VARCHAR(25) DEFAULT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
		System.out.println("The table customers has created");
	}

	public void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE customers");
		System.out.println("The table customers is a drop");
	}

	public void insert(String firstName, String lastName, String email, String password) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("insert into customers (FIRST_NAME,lAST_NAME,EMAIL,PASSWORD) values ('"
				+ firstName + "','" + lastName + "','" + email + "','" + password + "')");
		System.out.println("insert customers has succeed");
	}

	public void delete(int indexToDelete) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DELETE FROM customers WHERE ID=" + indexToDelete);
		System.out.println("delete from customers has done");
	}

	public void update(String firstName, String lastName, String email, String passWord, int index)
			throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("UPDATE customers SET FIRST_NAME='" + firstName + "',lAST_NAME='" + lastName
				+ "', EMAIL='" + email + "', PASSWORD='" + passWord + "' WHERE ID=" + index);
		System.out.println("update customers has done");
	}

	public void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers");
		while (re.next())
			System.out.println("ID: " + re.getInt("ID") + " ,FIRST_NAME: " + re.getString("FIRST_NAME")
					+ " ,lAST_NAME: " + re.getString("lAST_NAME") + " ,EMAIL: " + re.getString("EMAIL") + " ,PASSWORD:"
					+ re.getString("PASSWORD"));
	}

}
