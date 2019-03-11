package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import beans.Category;
import beans.Coupon;
import dao.ICouponsDao;
import exception.ExceptionName;
import utils.DateUtils;

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

	private ConnectionPool connection = ConnectionPool.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#insert(javaBeans.Coupon)
	 */
	public void insert(Coupon coupon) throws Exception {

		if (!(coupon.getStartDate().before(coupon.getEndDate())))
			throw new ExceptionName("This date isn't well! (must be start date before end date)");
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (result.next())
				if (result.getInt("COMPANY_ID") == coupon.getCompanyId()
						&& result.getString("TITLE").equals(coupon.getTitle()))
					throw new ExceptionName("The coupon already exist on data base");

			PreparedStatement preparedStatement = con.prepareStatement(
					"INSERT INTO coupons (COMPANY_ID,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ");
			preparedStatement.setInt(1, coupon.getCompanyId());
			preparedStatement.setInt(2, coupon.getCategoryId());
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
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#delete(int)
	 */
	public void delete(int couponID) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();

			PreparedStatement preparedStatement1 = con
					.prepareStatement("DELETE FROM customersVsCoupons WHERE COUPON_ID = ?");
			preparedStatement1.setInt(1, couponID);
			preparedStatement1.executeUpdate();

			PreparedStatement preparedStatement2 = con.prepareStatement("DELETE FROM coupons WHERE ID = ?");
			preparedStatement2.setInt(1, couponID);
			preparedStatement2.executeUpdate();

			System.out.println("delete from coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#delete(int, int)
	 */
	public void delete(int couponID, int companyID) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement()
					.executeQuery("SELECT * FROM coupons WHERE ID=" + couponID + " AND COMPANY_ID=" + companyID);
			while (!result.next())
				throw new ExceptionName("Don't have this coupon for this company");

			PreparedStatement preparedStatement1 = con
					.prepareStatement("DELETE FROM customersVsCoupons WHERE COUPON_ID = ?");
			preparedStatement1.setInt(1, couponID);
			preparedStatement1.executeUpdate();

			PreparedStatement preparedStatement2 = con.prepareStatement("DELETE FROM coupons WHERE ID = ?");
			preparedStatement2.setInt(1, couponID);
			preparedStatement2.executeUpdate();

			System.out.println("delete from coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#update(javaBeans.Coupon)
	 */
	public void update(Coupon coupon) throws Exception {

		if (!(coupon.getStartDate().before(coupon.getEndDate())))
			throw new ExceptionName("This date isn't well! (must be start date before end date)");

		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (result.next())
				if (result.getInt("COMPANY_ID") == coupon.getCompanyId()
						&& result.getInt("CATEGORY_ID") == coupon.getCategoryId()
						&& result.getString("TITLE").equals(coupon.getTitle())
						&& result.getString("DESCRIPTION").equals(coupon.getDescription())
						&& result.getString("IMAGE").equals(coupon.getImage())
						&& result.getInt("AMOUNT") == coupon.getAmount())
					throw new ExceptionName("The coupon already exist on data base");

			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE coupons SET COMPANY_ID=? , CATEGORY_ID=? , TITLE=? , DESCRIPTION=? ,"
							+ " START_DATE=? , END_DATE=? , AMOUNT=? , PRICE=? , IMAGE=?  WHERE ID=?");
			preparedStatement.setInt(1, coupon.getCompanyId());
			preparedStatement.setInt(2, coupon.getCategoryId());
			preparedStatement.setString(3, coupon.getTitle());
			preparedStatement.setString(4, coupon.getDescription());
			preparedStatement.setDate(5, DateUtils.javaDateToSqlDate(coupon.getStartDate()));
			preparedStatement.setDate(6, DateUtils.javaDateToSqlDate(coupon.getEndDate()));
			preparedStatement.setInt(7, coupon.getAmount());
			preparedStatement.setDouble(8, coupon.getPrice());
			preparedStatement.setString(9, coupon.getImage());
			preparedStatement.setInt(10, coupon.getId());
			preparedStatement.executeUpdate();

			System.out.println("update coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getAllCoupon()
	 */
	@Override
	public ArrayList<Coupon> getAllCoupon() throws Exception {
		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (result.next()) {
				Category category = null;
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
	 * @see dao.ICouponsDAO#getOneCoupon(int)
	 */
	public Coupon getOneCoupon(int couponID) throws Exception {
		Connection con = null;
		Coupon coupon = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM coupons where id=" + couponID);
			Category category = null;
			while (result.next()) {
				for (Category ca : Category.values())
					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				coupon = new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
						result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
						result.getString("IMAGE"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return coupon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#addCouponPurchase(int, int)
	 */
	@Override
	public void addCouponPurchase(int customerId, int couponId) throws Exception {
		Connection con = null;
		Coupon newCoupon = getOneCoupon(couponId);
		if (newCoupon == null || newCoupon.getAmount() < 1)
			throw new ExceptionName("Don't have anymore from this coupon!");
		if (!(newCoupon.getStartDate().before(new Date()) && newCoupon.getEndDate().after(new Date())))
			throw new ExceptionName(
					"The date can be only in (" + newCoupon.getStartDate() + " - " + newCoupon.getEndDate() + ")");
		newCoupon.setAmount(newCoupon.getAmount() - 1);
		update(newCoupon);
		try {
			con = connection.getConnection();

			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO customersVsCoupons (CUSTOMER_ID,COUPON_ID) VALUES ( ? , ?)");
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, couponId);
			preparedStatement.executeUpdate();

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
	 * @see dao.ICouponsDAO#deleteCouponPurchase(int, int)
	 */
	@Override
	public void deleteCouponPurchase(int customerId, int couponId) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();

			PreparedStatement preparedStatement = con
					.prepareStatement("DELETE FROM customersVsCoupons WHERE CUSTOMER_ID = ? AND COUPON_ID = ?");
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, couponId);
			preparedStatement.executeUpdate();

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
	 * @see dao.ICouponsDAO#getCompanyCouponsByID(int)
	 */
	public ArrayList<Coupon> getCompanyCouponsByID(int companyID) throws Exception {

		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement()
					.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyID);
			while (result.next()) {
				Category category = null;
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
	 * @see dao.ICouponsDAO#getCompanyCouponsByMaxPrice(double, int)
	 */
	public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, int companyID) throws Exception {
		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement()
					.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyID);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICouponsDAO#getCompanyCouponsByCategory(javaBeans.Category, int)
	 */
	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category, int companyID) throws Exception {
		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement()
					.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyID);
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
	 * @see dao.ICouponsDAO#getAllexpiredCouponsById()
	 */
	public ArrayList<Integer> getAllexpiredCouponsById() throws Exception {

		Connection con = null;
		ArrayList<Integer> list = new ArrayList<>();
		Date date = new Date();
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT ID , END_DATE FROM coupons");
			while (result.next()) {
				if (date.after(result.getDate("END_DATE")))
					list.add(result.getInt("ID"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return list;
	}

}
