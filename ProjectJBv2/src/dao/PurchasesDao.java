package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Coupon;
import enums.Category;
import enums.ProblemsException;
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPurchasesDao#delete(long)
	 */
	public void refundCouponByCouponId(long couponId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM purchases WHERE COUPON_ID = ? ");
			preparedStatement.setLong(1, couponId);
			preparedStatement.executeUpdate();

			System.out.println("delete from purchases has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	public void refundCouponByCustomerId(long customerId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM purchases WHERE CUSTOMER_ID = ? ");
			preparedStatement.setLong(1, customerId);
			preparedStatement.executeUpdate();

			System.out.println("delete from purchases has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

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

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	public boolean isCustomerBoughtByCoustomerId(long customerId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM purchases WHERE CUSTOMER_ID = ? ");
			preparedStatement.setLong(1, customerId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
	public int getAmount(long customerId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int amount = 0;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT AMOUNT FROM purchases WHERE CUSTOMER_ID = ? ");
			preparedStatement.setLong(1, customerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				amount += resultSet.getInt("AMOUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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

	public List<Coupon> getCustomerCouponsByCustomerId(long customerId) throws ApplicationException {
		List<Coupon> list = new ArrayList<Coupon>();
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
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException {
		List<Coupon> list = new ArrayList<Coupon>();

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
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {
		List<Coupon> list = new ArrayList<Coupon>();
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
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		}
		return preparedStatement;
	}

}
