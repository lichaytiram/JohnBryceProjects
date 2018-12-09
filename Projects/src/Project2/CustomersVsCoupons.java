package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersVsCoupons {
	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS customersVsCoupons (CUSTOMER_ID INT(200) NOT NULL AUTO_INCREMENT REFERENCES customers(ID),"
						+ "COUPON_ID INT(200) NOT NULL REFERENCES coupons(ID),"
						+ "PRIMARY KEY(CUSTOMER_ID,COUPON_ID))");
		System.out.println("The table customersVsCoupons has created");
	}
 
	public static void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE customersVsCoupons");
		System.out.println("The table customersVsCoupons is a drop");
	}

	public static void insert(String Name) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("insert into customersVsCoupons (NAME) values ('" + Name + "')");
		System.out.println("insert customersVsCoupons has succeed");
	}

	public static void delete(int indexToDelete) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DELETE FROM customersVsCoupons WHERE ID=" + indexToDelete);
		System.out.println("delete from customersVsCoupons has done");
	}

	public static void update(String Name, int index) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("UPDATE customersVsCoupons SET NAME='" + Name + "' WHERE ID=" + index);
		System.out.println("update customersVsCoupons has done");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
		while (re.next())
			System.out.println("ID: " + re.getInt("ID") + " ,NAME: " + re.getString("NAME"));
	}

}
