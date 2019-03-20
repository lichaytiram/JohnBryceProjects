package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Coupon;
import enums.Category;
import exception.ApplicationException;
import utils.JdbcUtils;

/**
 * This class create a connection with data base ( with name customersVsCoupons)
 * 
 * @author Lichay
 *
 */
public class PurchasesDao implements IPurchasesDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#insert(long, long ,int )
	 */
	public void purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection
					.prepareStatement("INSERT INTO purchases (CUSTOMER_ID,COUPON_ID,AMOUNT) VALUES ( ? , ? , ? )");
			preparedStatement(preparedStatement, customerId, couponId);
			preparedStatement.setInt(3, amount);
			preparedStatement.executeUpdate();
			System.out.println("insert purchases has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#delete(long, long)
	 */
	public void refundCoupon(long customerId, long couponId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("DELETE FROM purchases WHERE CUSTOMER_ID = ? AND COUPON_ID = ? ");
			preparedStatement(preparedStatement, customerId, couponId);
			preparedStatement.executeUpdate();

			System.out.println("delete from purchases has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#delete(long)
	 */
	public void refundCoupon(long id) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM purchases WHERE ID = ? ");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();

			System.out.println("delete from purchases has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#updateAmount(long, amount)
	 */
	public void updateAmount(long id, int amount) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("UPDATE purchases SET AMOUNT = ? WHERE ID = ? ");
			preparedStatement.setInt(1, amount);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();

			System.out.println("update purchases has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

//	/**
//	 * @throws Exception This function can throw an exception
//	 */
//
//	public void showAllPurchases() throws Exception {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			connection = JdbcUtils.getConnection();
//			ResultSet result = connection.createStatement().executeQuery("SELECT * FROM purchases");
//			while (result.next())
//				System.out.println(
//						"CUSTOMER_ID: " + result.getInt("CUSTOMER_ID") + " ,COUPON_ID: " + result.getInt("COUPON_ID"));
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			JdbcUtils.closeResources(connection, preparedStatement);
//		}
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#isCustomerBought(long, long)
	 */
	public boolean isCustomerBought(long customerId, long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT * FROM purchases WHERE CUSTOMER_ID = ? AND COUPON_ID = ? ");
			preparedStatement(preparedStatement, customerId, couponId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#isCustomerBought(long)
	 */
	public boolean isCustomerBought(long id) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM purchases WHERE ID = ? ");
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#getAmount(long)
	 */
	public int getAmount(long coustomerId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int amount = 0;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT AMOUNT FROM purchases WHERE CUSTOMER_ID = ? ");
			preparedStatement.setLong(1, coustomerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				amount += resultSet.getInt("AMOUNT");
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#getCustomerCouponByCustomerID(long)
	 */

	public ArrayList<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {
		ArrayList<Coupon> list = new ArrayList<Coupon>();
		Category category = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT * from purchases JOIN coupons ON coupons.ID = purchases.COUPON_ID WHERE CUSTOMER_ID = ?");
			preparedStatement.setLong(1, customerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				category = Category.valueOf(resultSet.getString("CATEGORY"));
				list.add(new Coupon(resultSet.getInt("ID"), resultSet.getInt("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("have a problem:\n" + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#getCustomerCouponByCategory(long, javaBeans.Category)
	 */
	public ArrayList<Coupon> getCustomerCouponByCategory(long customerId, Category category)
			throws ApplicationException {
		ArrayList<Coupon> list = new ArrayList<Coupon>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT * from purchases JOIN coupons ON coupons.ID = purchases.COUPON_ID WHERE CUSTOMER_ID = ? AND CATEGORY = ?");
			preparedStatement.setLong(1, customerId);
			preparedStatement.setString(2, category.name());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(new Coupon(resultSet.getInt("ID"), resultSet.getInt("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("have a problem:\n" + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#getCustomerCouponByMaxPrice(long, double)
	 */
	public ArrayList<Coupon> getCustomerCouponByMaxPrice(long customerId, double maxPrice) throws ApplicationException {
		ArrayList<Coupon> list = new ArrayList<Coupon>();
		Category category = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT * from purchases JOIN coupons ON coupons.ID = purchases.COUPON_ID WHERE CUSTOMER_ID = ? AND PRICE <= ?");
			preparedStatement.setLong(1, customerId);
			preparedStatement.setDouble(2, maxPrice);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				category = Category.valueOf(resultSet.getString("CATEGORY"));
				list.add(new Coupon(resultSet.getInt("ID"), resultSet.getInt("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("have a problem:\n" + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;
	}

	// extract

	private PreparedStatement preparedStatement(PreparedStatement preparedStatement, long customerId, long couponId)
			throws ApplicationException {

		try {
			preparedStatement.setLong(1, customerId);
			preparedStatement.setLong(2, couponId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Have a problem:\n" + e);
		}
		return preparedStatement;
	}

}