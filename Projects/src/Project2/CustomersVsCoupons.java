package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersVsCoupons implements ICustomersVsCouponsDAO2 {
	public void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS customersVsCoupons (CUSTOMER_ID INT(200) UNSIGNED NOT NULL REFERENCES customers(ID),"
						+ "COUPON_ID INT(200) UNSIGNED NOT NULL REFERENCES coupons(ID),"
						+ "PRIMARY KEY(CUSTOMER_ID,COUPON_ID))");
		System.out.println("The table customersVsCoupons has created");
	}

	public void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE customersVsCoupons");
		System.out.println("The table customersVsCoupons is a drop");
	}

	public void insert(int customerId, int couponId) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"insert into customersVsCoupons (CUSTOMER_ID,COUPON_ID) values (" + customerId + "," + couponId + ")");
		System.out.println("insert customersVsCoupons has succeed");
	}

	public void delete(int customerId, int couponId) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"DELETE FROM customersVsCoupons WHERE CUSTOMER_ID =" + customerId + " AND COUPON_ID =" + couponId);
		System.out.println("delete from customersVsCoupons has done");
	}

	public void update(int oldCustomerId, int newCustomerId, int oldCouponId, int newCouponId) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement()
				.executeUpdate("UPDATE customersVsCoupons SET CUSTOMER_ID=" + newCustomerId + ", COUPON_ID="
						+ newCouponId + " WHERE CUSTOMER_ID =" + oldCustomerId + " AND COUPON_ID =" + oldCouponId);
		System.out.println("update customersVsCoupons has done");
	}

	public void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
		while (re.next())
			System.out
					.println("CUSTOMER_ID: " + re.getInt("CUSTOMER_ID") + " ,COUPON_ID: " + re.getString("COUPON_ID"));
	}

}
