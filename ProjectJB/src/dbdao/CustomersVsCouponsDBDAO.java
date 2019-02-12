package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ICustomersVsCouponsDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Coupon;

public class CustomersVsCouponsDBDAO implements ICustomersVsCouponsDAO {

	private ConnectionPool connection = ConnectionPool.getInstance();

	public void create() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS customersVsCoupons (CUSTOMER_ID INT(200) UNSIGNED NOT NULL ,"
							+ "COUPON_ID INT(200) UNSIGNED NOT NULL ," + "PRIMARY KEY(CUSTOMER_ID,COUPON_ID),"
							+ "FOREIGN KEY(CUSTOMER_ID) REFERENCES customers(ID),"
							+ "FOREIGN KEY(COUPON_ID) REFERENCES coupons(ID))");
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
				System.out
						.println("CUSTOMER_ID: " + re.getInt("CUSTOMER_ID") + " ,COUPON_ID: " + re.getInt("COUPON_ID"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void checkIfCustomerBought(int customerId, int couponId) throws Exception {

		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
			while (re.next())
				if (customerId == re.getInt("CUSTOMER_ID") && couponId == re.getInt("COUPON_ID"))
					throw new ExceptionName("The customer already bought this coupon");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public ArrayList<Coupon> getCustomerCouponByCustomerID(int customerID) throws Exception {
		ArrayList<Coupon> list = new ArrayList<Coupon>();

		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery(
					"SELECT * from customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE CUSTOMER_ID="+customerID);
			Category category = null;
			while (re.next()) {
				for (Category ca : Category.values())
					if (ca.ordinal() == re.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}

				list.add(new Coupon(re.getInt("ID"), re.getInt("COMPANY_ID"), category, re.getString("TITLE"),
						re.getString("DESCRIPTION"), re.getDate("START_DATE"), re.getDate("END_DATE"),
						re.getInt("AMOUNT"), re.getDouble("PRICE"), re.getString("IMAGE")));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}

		return list;
	}

}
