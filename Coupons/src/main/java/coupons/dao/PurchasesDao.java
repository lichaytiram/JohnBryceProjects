package coupons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import coupons.beans.Purchase;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.DateUtils;
import coupons.utils.JdbcUtils;

/**
 * This class create a connection with data base
 * 
 * @author Lichay
 *
 */
@Repository
public class PurchasesDao implements IPurchasesDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long purchaseCoupon(Purchase purchase) throws ApplicationException {

		Date currentDate = new Date();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO purchases (CUSTOMER_ID,COUPON_ID,AMOUNT,DATE) VALUES ( ? , ? , ? , ? )",
					PreparedStatement.RETURN_GENERATED_KEYS);

			// call to private function that prepared the statement
			preparedStatement(preparedStatement, purchase.getCustomerId(), purchase.getCouponId());
			preparedStatement.setInt(3, purchase.getAmount());
			preparedStatement.setDate(4, DateUtils.javaDateToSqlDate(currentDate));

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				return resultSet.getLong(1);
			}

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePurchase(long customerId, long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("DELETE FROM purchases WHERE CUSTOMER_ID = ? AND COUPON_ID = ?");

			// call to private function that prepared the statement
			preparedStatement(preparedStatement, customerId, couponId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePurchase(long id) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM purchases WHERE ID = ?");
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePurchaseByCouponId(long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM purchases WHERE COUPON_ID = ?");
			preparedStatement.setLong(1, couponId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePurchaseByCustomerId(long customerId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM purchases WHERE CUSTOMER_ID = ?");
			preparedStatement.setLong(1, customerId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePurchaseByCompanyId(long companyId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"DELETE FROM purchases WHERE COUPON_ID IN ( SELECT ID FROM coupons WHERE COMPANY_ID = ? )");
			preparedStatement.setLong(1, companyId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteExpiredPurchase() throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"DELETE FROM purchases WHERE COUPON_ID IN ( SELECT ID FROM coupons WHERE END_DATE < NOW() )");

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCustomerPurchase(long customerId, long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT * FROM purchases WHERE CUSTOMER_ID = ? AND COUPON_ID = ?");

			// call to private function that prepared the statement
			preparedStatement(preparedStatement, customerId, couponId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCustomerPurchase(long id) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM purchases WHERE ID = ?");
			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPurchaseAmount(long customerId) throws ApplicationException {

		int amount = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT AMOUNT FROM purchases WHERE CUSTOMER_ID = ?");
			preparedStatement.setLong(1, customerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				amount += resultSet.getInt("AMOUNT");
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return amount;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Purchase> getAllPurchases() throws ApplicationException {

		Purchase purchase = null;
		List<Purchase> list = new ArrayList<Purchase>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM purchases");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				purchase = new Purchase(resultSet.getLong("ID"), resultSet.getLong("CUSTOMER_ID"),
						resultSet.getLong("COUPON_ID"), resultSet.getInt("AMOUNT"), resultSet.getDate("DATE"));

				list.add(purchase);

			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException {

		Purchase purchase = null;
		List<Purchase> list = new ArrayList<Purchase>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM purchases WHERE CUSTOMER_ID = ?");
			preparedStatement.setLong(1, customerId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				purchase = new Purchase(resultSet.getLong("ID"), resultSet.getLong("CUSTOMER_ID"),
						resultSet.getLong("COUPON_ID"), resultSet.getInt("AMOUNT"), resultSet.getDate("DATE"));

				list.add(purchase);

			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

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

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		}
		return preparedStatement;

	}

}
