package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Coupon;
import enums.Category;
import enums.ErrorType;
import exception.ApplicationException;
import utils.DateUtils;
import utils.JdbcUtils;

/**
 * This class create a connection with data base ( with name coupons )
 * 
 * @author Lichay
 *
 */
/**
 * @author Lichay
 *
 */
public class CouponsDao implements ICouponsDao {

	@Override
	public void createCoupon(Coupon coupon) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO coupons (COMPANY_ID,CATEGORY,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ");
			preparedStatement(preparedStatement, coupon);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public void deleteCoupon(long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public void deleteCouponbyCompanyId(long companyId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM coupons WHERE COMPANY_ID = ?");
			preparedStatement.setLong(1, companyId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public void updateCoupon(Coupon coupon) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("UPDATE coupons SET COMPANY_ID = ? , CATEGORY = ? , TITLE = ? , DESCRIPTION = ? ,"
							+ " START_DATE = ? , END_DATE = ? , AMOUNT = ? , PRICE = ? , IMAGE = ?  WHERE ID = ?");
			preparedStatement(preparedStatement, coupon);
			preparedStatement.setLong(10, coupon.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public void updateCoupon(long couponId, int amount) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("UPDATE coupons SET AMOUNT = ? WHERE ID = ?");
			preparedStatement.setInt(1, amount);
			preparedStatement.setLong(2, couponId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public List<Coupon> getAllCoupon() throws ApplicationException {

		Category category = null;
		List<Coupon> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM coupons");
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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;

	}

	@Override
	public Coupon getCoupon(long couponId) throws ApplicationException {

		Category category = null;
		Coupon coupon = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				category = Category.valueOf(resultSet.getString("CATEGORY"));

				coupon = new Coupon(resultSet.getInt("ID"), resultSet.getInt("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return coupon;

	}

	@Override
	public boolean isCouponExists(long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT ID FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;

	}

	@Override
	public boolean isCouponExists(Coupon coupon) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM coupons WHERE TITLE = ? AND COMPANY_ID = ?");
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setLong(2, coupon.getCompanyId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;

	}

	@Override
	public boolean isCouponValid(long couponId) throws ApplicationException {

		Date date = new Date();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT END_DATE FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (resultSet.getDate("END_DATE").after(date))
					return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;

	}

	@Override
	public int howMuchCouponRemain(long couponId) throws ApplicationException {

		int amount = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT AMOUNT FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				amount = resultSet.getInt("AMOUNT");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return amount;

	}

	@Override
	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException {

		Category category = null;
		List<Coupon> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM coupons WHERE COMPANY_ID = ?");
			preparedStatement.setLong(1, companyId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				category = Category.valueOf(resultSet.getString("CATEGORY"));
				list.add(new Coupon(resultSet.getLong("ID"), resultSet.getLong("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;

	}

	@Override
	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category) throws ApplicationException {

		List<Coupon> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT * FROM coupons WHERE COMPANY_ID = ? AND CATEGORY = ?");
			preparedStatement.setLong(1, companyId);
			preparedStatement.setString(2, category.toString().toUpperCase());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(new Coupon(resultSet.getLong("ID"), resultSet.getLong("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;

	}

	@Override
	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException {

		Category category = null;
		List<Coupon> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT * FROM coupons WHERE COMPANY_ID = ? AND PRICE <= ?");
			preparedStatement.setLong(1, companyId);
			preparedStatement.setDouble(2, maxPrice);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				category = Category.valueOf(resultSet.getString("CATEGORY"));
				list.add(new Coupon(resultSet.getLong("ID"), resultSet.getLong("COMPANY_ID"), category,
						resultSet.getString("TITLE"), resultSet.getString("DESCRIPTION"),
						resultSet.getDate("START_DATE"), resultSet.getDate("END_DATE"), resultSet.getInt("AMOUNT"),
						resultSet.getDouble("PRICE"), resultSet.getString("IMAGE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;

	}

	@Override
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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;

	}

	@Override
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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;

	}

	@Override
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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;

	}

	// extract

	private PreparedStatement preparedStatement(PreparedStatement preparedStatement, Coupon coupon)
			throws ApplicationException {

		try {
			preparedStatement.setLong(1, coupon.getCompanyId());
			preparedStatement.setString(2, coupon.getCategory().name());
			preparedStatement.setString(3, coupon.getTitle());
			preparedStatement.setString(4, coupon.getDescription());
			preparedStatement.setDate(5, DateUtils.javaDateToSqlDate(coupon.getStartDate()));
			preparedStatement.setDate(6, DateUtils.javaDateToSqlDate(coupon.getEndDate()));
			preparedStatement.setInt(7, coupon.getAmount());
			preparedStatement.setDouble(8, coupon.getPrice());
			preparedStatement.setString(9, coupon.getImage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		}
		return preparedStatement;
	}

}
