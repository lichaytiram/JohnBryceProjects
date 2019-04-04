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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#insert(javaBeans.Coupon)
	 */
	public void createCoupon(Coupon coupon) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO coupons (COMPANY_ID,CATEGORY,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ");
			preparedStatement(preparedStatement, coupon);
			preparedStatement.executeUpdate();
			System.out.println("insert coupons has succeed");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#delete(int)
	 */
	public void deleteCoupon(long couponId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			preparedStatement.executeUpdate();

			System.out.println("delete from coupons has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	public void deleteCouponbyCompanyId(long companyId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM coupons WHERE COMPANY_ID = ?");
			preparedStatement.setLong(1, companyId);
			preparedStatement.executeUpdate();

			System.out.println("delete from coupons has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#update(javaBeans.Coupon)
	 */
	public void updateCoupon(Coupon coupon) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("UPDATE coupons SET COMPANY_ID=? , CATEGORY=? , TITLE=? , DESCRIPTION=? ,"
							+ " START_DATE=? , END_DATE=? , AMOUNT=? , PRICE=? , IMAGE=?  WHERE ID=?");
			preparedStatement(preparedStatement, coupon);
			preparedStatement.setLong(10, coupon.getId());
			preparedStatement.executeUpdate();

			System.out.println("update coupons has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	public void updateCoupon(long couponId, int amount) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("UPDATE coupons SET AMOUNT=? WHERE ID = ?");
			preparedStatement.setInt(1, amount);
			preparedStatement.setLong(2, couponId);
			preparedStatement.executeUpdate();

			System.out.println("update coupons has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getAllCoupon()
	 */
	@Override
	public List<Coupon> getAllCoupon() throws ApplicationException {
		List<Coupon> list = new ArrayList<>();
		Category category = null;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getOneCoupon(int)
	 */
	public Coupon getCoupon(long couponId) throws ApplicationException {
		Category category = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM coupons WHERE id = ?");
			preparedStatement.setLong(1, couponId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				category = Category.valueOf(resultSet.getString("CATEGORY"));
				return new Coupon(resultSet.getInt("ID"), resultSet.getInt("COMPANY_ID"), category,
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
		return null; // throws exception
	}

	// how to receive category
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getCompanyCouponsByID(long)
	 */
	public List<Coupon> getCompanyCouponsById(long companyId) throws ApplicationException {

		List<Coupon> list = new ArrayList<>();
		Category category = null;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getCompanyCouponsByMaxPrice(double, long)
	 */
	public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, long companyId) throws ApplicationException {
		List<Coupon> list = new ArrayList<>();
		Category category = null;
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

//			result = con.createStatement().executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyId);
//			Category category = null;
//
//			while (result.next()) {
//				if (result.getDouble("PRICE") < maxPrice) {
//					for (Category ca : Category.values())
//						if (ca.ordinal() == result.getInt("CATEGORY")) {
//							category = ca;
//							break;
//						}
//					list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//							result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
//							result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
//							result.getString("IMAGE")));
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getCompanyCouponsByCategory(javaBeans.Category, long)
	 */
	public List<Coupon> getCompanyCouponsByCategory(Category category, long companyId) throws ApplicationException {
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

//			result = con.createStatement().executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyId);
//			while (result.next()) {
//				if (category.ordinal() == result.getInt("CATEGORY"))
//					list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//							result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
//							result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
//							result.getString("IMAGE")));
//			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getAllexpiredCouponsById()
	 */
	public List<Integer> getAllexpiredCouponsId() throws ApplicationException {

		List<Integer> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Date date = new Date();
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT ID , END_DATE FROM coupons");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (date.after(resultSet.getDate("END_DATE"))) {
					list.add(resultSet.getInt("ID"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;
	}

	public List<Long> getAllCouponsIdByCompanyId(long companyId) throws ApplicationException {

		List<Long> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT ID FROM coupons WHERE COMPANY_ID = ?");
			preparedStatement.setLong(1, companyId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(resultSet.getLong("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;
	}

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

	public boolean isCouponExists(Coupon coupon) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection
					.prepareStatement("SELECT * FROM coupons WHERE TITLE = ? AND COMPANY_ID = ? ");
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

	public boolean isCouponValid(long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Date date = new Date();
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT END_DATE FROM coupons WHERE ID = ? ");
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

	public int howMuchCouponRemain(long couponId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int amount = 0;

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
