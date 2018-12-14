package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersVsCoupons implements ICustomersVsCouponsDAO {

	private ConnectionPool connection = ConnectionPool.getInstance();

	public void create() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS customersVsCoupons (CUSTOMER_ID INT(200) UNSIGNED NOT NULL REFERENCES customers(ID),"
							+ "COUPON_ID INT(200) UNSIGNED NOT NULL REFERENCES coupons(ID),"
							+ "PRIMARY KEY(CUSTOMER_ID,COUPON_ID))");
			System.out.println("The table customersVsCoupons has created");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void drop() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DROP TABLE customersVsCoupons");
			System.out.println("The table customersVsCoupons is a drop");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void insert(int customerId, int couponId) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("insert into customersVsCoupons (CUSTOMER_ID,COUPON_ID) values ("
					+ customerId + "," + couponId + ")");
			System.out.println("insert customersVsCoupons has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void delete(int customerId, int couponId) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"DELETE FROM customersVsCoupons WHERE CUSTOMER_ID =" + customerId + " AND COUPON_ID =" + couponId);
			System.out.println("delete from customersVsCoupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void update(int oldCustomerId, int newCustomerId, int oldCouponId, int newCouponId) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement()
					.executeUpdate("UPDATE customersVsCoupons SET CUSTOMER_ID=" + newCustomerId + ", COUPON_ID="
							+ newCouponId + " WHERE CUSTOMER_ID =" + oldCustomerId + " AND COUPON_ID =" + oldCouponId);
			System.out.println("update customersVsCoupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void showAll() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
			while (re.next())
				System.out.println(
						"CUSTOMER_ID: " + re.getInt("CUSTOMER_ID") + " ,COUPON_ID: " + re.getString("COUPON_ID"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

}
