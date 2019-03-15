package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Category;
import beans.Coupon;
import dao.ICustomersVsCouponsDao;
import exception.ExceptionName;
import utils.JdbcUtils;

/**
 * This class create a connection with data base ( with name customersVsCoupons)
 * 
 * @author Lichay
 *
 */
public class CustomersVsCouponsDao implements ICustomersVsCouponsDao {


	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#insert(int, int)
	 */
	public void insert(long customerId, long couponId) throws Exception {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			connection.createStatement().executeUpdate("insert into customersVsCoupons (CUSTOMER_ID,COUPON_ID) values ("
					+ customerId + "," + couponId + ")");
			System.out.println("insert customersVsCoupons has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#delete(int, int)
	 */
	public void delete(long customerId, long couponId) throws Exception {
		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
			con.createStatement().executeUpdate(
					"DELETE FROM customersVsCoupons WHERE CUSTOMER_ID =" + customerId + " AND COUPON_ID =" + couponId);
			System.out.println("delete from customersVsCoupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#update(int, int, int, int)
	 */
	public void update(long oldCustomerId, long newCustomerId, long oldCouponId, long newCouponId) throws Exception {
		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
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

	/**
	 * @throws Exception This function can throw an exception
	 */
	public void showAll() throws Exception {
		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
			while (result.next())
				System.out.println(
						"CUSTOMER_ID: " + result.getInt("CUSTOMER_ID") + " ,COUPON_ID: " + result.getInt("COUPON_ID"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#checkIfCustomerBought(int, int)
	 */
	public void checkIfCustomerBought(long customerId, long couponId) throws Exception {

		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customersVsCoupons");
			while (result.next())
				if (customerId == result.getInt("CUSTOMER_ID") && couponId == result.getInt("COUPON_ID"))
					throw new ExceptionName("The customer already bought this coupon");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#getCustomerCouponByCustomerID(int)
	 */
	public ArrayList<Coupon> getCustomerCouponByCustomerID(long customerID) throws Exception {
		ArrayList<Coupon> list = new ArrayList<Coupon>();

		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
			ResultSet result = con.createStatement().executeQuery(
					"SELECT * from customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE CUSTOMER_ID="
							+ customerID);
			Category category = null;
			while (result.next()) {
				for (Category ca : Category.values())
					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}

				list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
						result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
						result.getString("IMAGE")));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#getCustomerCouponByCategory(int,
	 * javaBeans.Category)
	 */
	public ArrayList<Coupon> getCustomerCouponByCategory(long customerID, Category category) throws Exception {
		ArrayList<Coupon> list = new ArrayList<Coupon>();

		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
			ResultSet result = con.createStatement().executeQuery(
					"SELECT * from customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE CUSTOMER_ID="
							+ customerID);
			while (result.next()) {
				if (category.ordinal() == result.getInt("CATEGORY_ID"))
					list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
							result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
							result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
							result.getString("IMAGE")));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersVsCouponsDAO#getCustomerCouponByMaxPrice(int, double)
	 */
	public ArrayList<Coupon> getCustomerCouponByMaxPrice(long customerID, double maxPrice) throws Exception {
		ArrayList<Coupon> list = new ArrayList<Coupon>();

		Connection con = null;
		try {
			connection = JdbcUtils.getConnection();
			ResultSet result = con.createStatement().executeQuery(
					"SELECT * from customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE CUSTOMER_ID="
							+ customerID);
			Category category = null;
			while (result.next()) {

				if (result.getDouble("PRICE") < maxPrice) {
					for (Category ca : Category.values())
						if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
							category = ca;
							break;
						}

					list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
							result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
							result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
							result.getString("IMAGE")));
				}
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}

		return list;
	}

}
