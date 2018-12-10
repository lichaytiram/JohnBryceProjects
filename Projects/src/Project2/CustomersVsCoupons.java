package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersVsCoupons {
	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS customersVsCoupons (CUSTOMER_ID INT(200) NOT NULL REFERENCES customers(ID),"
						+ "COUPON_ID INT(200) NOT NULL REFERENCES coupons(ID),"
						+ "PRIMARY KEY(CUSTOMER_ID,COUPON_ID))");
		System.out.println("The table customersVsCoupons has created");
	}

	public static void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE customersVsCoupons");
		System.out.println("The table customersVsCoupons is a drop");
	}

	public static void insert(int customerId, int couponId) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"insert into customersVsCoupons (CUSTOMER_ID,COUPON_ID) values (" + customerId + "," + couponId + ")");
		System.out.println("insert customersVsCoupons has succeed");
	}

	public static void delete(int customerId, int couponId) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"DELETE FROM customersVsCoupons WHERE ID=CUSTOMER_ID" + customerId + ", COUPON_ID=" + couponId);
		System.out.println("delete from customersVsCoupons has done");
	}

// add where 2 items and add set
	public static void update(int customerId, int couponId) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement()
				.executeUpdate("UPDATE customersVsCoupons SET CUSTOMER_ID=" + customerId + " COUPON_ID=" + couponId);
		System.out.println("update customersVsCoupons has done");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
		while (re.next())
			System.out
					.println("CUSTOMER_ID: " + re.getInt("CUSTOMER_ID") + " ,COUPON_ID: " + re.getString("COUPON_ID"));
	}

}
