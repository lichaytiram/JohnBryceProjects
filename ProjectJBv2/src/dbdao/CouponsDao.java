package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import beans.Coupon;
import dao.ICouponsDao;
import enums.Category;
//import exception.ExceptionName;
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
	public void createCoupon(Coupon coupon) throws Exception {

//		if (!(coupon.getStartDate().before(coupon.getEndDate())))
//			throw new ExceptionName("This date isn't well! (must be start date before end date)");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM coupons");
//			while (result.next())
//				if (result.getInt("COMPANY_ID") == coupon.getCompanyId()
//						&& result.getString("TITLE").equals(coupon.getTitle()))
//					throw new ExceptionName("The coupon already exist on data base");

			preparedStatement = connection.prepareStatement(
					"INSERT INTO coupons (COMPANY_ID,CATEGORY,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ");
			preparedStatement.setLong(1, coupon.getCompanyId());
			preparedStatement.setString(2, coupon.getCategory().name());
			preparedStatement.setString(3, coupon.getTitle());
			preparedStatement.setString(4, coupon.getDescription());
			preparedStatement.setDate(5, DateUtils.javaDateToSqlDate(coupon.getStartDate()));
			preparedStatement.setDate(6, DateUtils.javaDateToSqlDate(coupon.getEndDate()));
			preparedStatement.setInt(7, coupon.getAmount());
			preparedStatement.setDouble(8, coupon.getPrice());
			preparedStatement.setString(9, coupon.getImage());
			preparedStatement.executeUpdate();
			System.out.println("insert coupons has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#delete(int)
	 */
	public void deleteCoupon(long couponId) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

//			PreparedStatement preparedStatement1 = con
//					.prepareStatement("DELETE FROM customersVsCoupons WHERE COUPON_ID = ?");
//			preparedStatement1.setLong(1, couponID);
//			preparedStatement1.executeUpdate();

			preparedStatement = connection.prepareStatement("DELETE FROM coupons WHERE ID = ?");
			preparedStatement.setLong(1, couponId);
			preparedStatement.executeUpdate();

			System.out.println("delete from coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see dao.ICouponsDAO#delete(int, int)
//	 */
//	public void delete(long couponId, long companyId) throws Exception {
//		Connection con = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			con = connection.getConnection();
//			ResultSet result = con.createStatement()
//					.executeQuery("SELECT * FROM coupons WHERE ID=" + couponId + " AND COMPANY_ID=" + companyId);
//			while (!result.next())
//				throw new ExceptionName("Don't have this coupon for this company");
//
//			PreparedStatement preparedStatement1 = con
//					.prepareStatement("DELETE FROM customersVsCoupons WHERE COUPON_ID = ?");
//			preparedStatement1.setLong(1, couponId);
//			preparedStatement1.executeUpdate();
//
//			PreparedStatement preparedStatement2 = con.prepareStatement("DELETE FROM coupons WHERE ID = ?");
//			preparedStatement2.setLong(1, couponId);
//			preparedStatement2.executeUpdate();
//
//			System.out.println("delete from coupons has done");
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			preparedStatement.close();
//			connection.restoreConnection(con);
//		}
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#update(javaBeans.Coupon)
	 */
	public void updateCoupon(Coupon coupon) throws Exception {

//		if (!(coupon.getStartDate().before(coupon.getEndDate())))
//			throw new ExceptionName("This date isn't well! (must be start date before end date)");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM coupons");
//			while (result.next())
//				if (result.getInt("COMPANY_ID") == coupon.getCompanyId()
//						&& result.getInt("CATEGORY") == coupon.getCategoryId()
//						&& result.getString("TITLE").equals(coupon.getTitle())
//						&& result.getString("DESCRIPTION").equals(coupon.getDescription())
//						&& result.getString("IMAGE").equals(coupon.getImage())
//						&& result.getInt("AMOUNT") == coupon.getAmount())
//					throw new ExceptionName("The coupon already exist on data base");

			preparedStatement = connection
					.prepareStatement("UPDATE coupons SET COMPANY_ID=? , CATEGORY=? , TITLE=? , DESCRIPTION=? ,"
							+ " START_DATE=? , END_DATE=? , AMOUNT=? , PRICE=? , IMAGE=?  WHERE ID=?");
			preparedStatement.setLong(1, coupon.getCompanyId());
			preparedStatement.setString(2, coupon.getCategory().name());
			preparedStatement.setString(3, coupon.getTitle());
			preparedStatement.setString(4, coupon.getDescription());
			preparedStatement.setDate(5, DateUtils.javaDateToSqlDate(coupon.getStartDate()));
			preparedStatement.setDate(6, DateUtils.javaDateToSqlDate(coupon.getEndDate()));
			preparedStatement.setInt(7, coupon.getAmount());
			preparedStatement.setDouble(8, coupon.getPrice());
			preparedStatement.setString(9, coupon.getImage());
			preparedStatement.setLong(10, coupon.getId());
			preparedStatement.executeUpdate();

			System.out.println("update coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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
	public ArrayList<Coupon> getAllCoupon() throws Exception {
		ArrayList<Coupon> list = new ArrayList<>();
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

//			result = con.createStatement().executeQuery("SELECT * FROM coupons");
//			while (result.next()) {
//				for (Category ca : Category.values()) {
//					if (ca.ordinal() == result.getInt("CATEGORY")) {
//						category = ca;
//						break;
//					}
//				}
//				list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
//						result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
//						result.getString("IMAGE")));
//			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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
	public Coupon getCoupon(long couponId) throws Exception {
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

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return null; // throws exception
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see dao.ICouponsDAO#addCouponPurchase(int, int)
//	 */
//	@Override
//	public void addCouponPurchase(long customerId, long couponId) throws Exception {
//		Coupon newCoupon = getCoupon(couponId);
//		Connection con = null;
//		PreparedStatement preparedStatement = null;
//		if (newCoupon == null || newCoupon.getAmount() < 1)
//			throw new ExceptionName("Don't have anymore from this coupon!");
//		if (!(newCoupon.getStartDate().before(new Date()) && newCoupon.getEndDate().after(new Date())))
//			throw new ExceptionName(
//					"The date can be only in (" + newCoupon.getStartDate() + " - " + newCoupon.getEndDate() + ")");
//		newCoupon.setAmount(newCoupon.getAmount() - 1);
//		update(newCoupon);
//		try {
//			con = connection.getConnection();
//
//			preparedStatement = con
//					.prepareStatement("INSERT INTO customersVsCoupons (CUSTOMER_ID,COUPON_ID) VALUES ( ? , ?)");
//			preparedStatement.setLong(1, customerId);
//			preparedStatement.setLong(2, couponId);
//			preparedStatement.executeUpdate();
//
//			System.out.println("insert customersVsCoupons has succeed");
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			preparedStatement.close();
//			connection.restoreConnection(con);
//		}
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see dao.ICouponsDAO#deleteCouponPurchase(int, int)
//	 */
//	@Override
//	public void deleteCouponPurchase(long customerId, long couponId) throws Exception {
//		Connection con = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			con = connection.getConnection();
//
//			preparedStatement = con
//					.prepareStatement("DELETE FROM customersVsCoupons WHERE CUSTOMER_ID = ? AND COUPON_ID = ?");
//			preparedStatement.setLong(1, customerId);
//			preparedStatement.setLong(2, couponId);
//			preparedStatement.executeUpdate();
//
//			System.out.println("delete from customersVsCoupons has done");
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			preparedStatement.close();
//			connection.restoreConnection(con);
//		}
//
//	}
	// how to receive category
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getCompanyCouponsByID(long)
	 */
	public ArrayList<Coupon> getCompanyCouponsById(long companyId) throws Exception {

		ArrayList<Coupon> list = new ArrayList<>();
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

//			result = con.createStatement().executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyId);
//			while (result.next()) {
//				Category category = null;
//				for (Category ca : Category.values())
//					if (ca.ordinal() == result.getInt("CATEGORY")) {
//						category = ca;
//						break;
//					}
//				list.add(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
//						result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
//						result.getString("IMAGE")));
//			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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
	public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, long companyId) throws Exception {
		ArrayList<Coupon> list = new ArrayList<>();
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
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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
	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category, long companyId) throws Exception {
		ArrayList<Coupon> list = new ArrayList<>();
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
		} catch (

		SQLException ex) {
			System.out.println(ex.getMessage());
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
	public ArrayList<Integer> getAllexpiredCouponsId() throws Exception {

		ArrayList<Integer> list = new ArrayList<>();
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
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;
	}

}
