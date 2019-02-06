package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ICouponsDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Coupon;
import utils.DateUtils;

public class CouponsDBDAO implements ICouponsDAO {

	private ConnectionPool connection = ConnectionPool.getInstance();

	public void create() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement()
					.executeUpdate("CREATE TABLE IF NOT EXISTS coupons (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,"
							+ " COMPANY_ID int(10) UNSIGNED NOT NULL REFERENCES companies(ID),"
							+ " CATEGORY_ID int(10) UNSIGNED NOT NULL REFERENCES categories(ID),"
							+ " TITLE  VARCHAR(25) NOT NULL, DESCRIPTION TEXT DEFAULT NULL, START_DATE TIMESTAMP ,"
							+ " END_DATE TIMESTAMP , AMOUNT int(200) UNSIGNED, PRICE DOUBLE PRECISION UNSIGNED, IMAGE VARCHAR(20) , PRIMARY KEY(ID) )");
			System.out.println("The table coupons has created");
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
			con.createStatement().executeUpdate("DROP TABLE coupons");
			System.out.println("The table coupons is a drop");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void insert(Coupon c) throws Exception {

		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (re.next())
				if (re.getInt("COMPANY_ID") == c.getCompanyId() && re.getInt("CATEGORY_ID") == c.getCategoryId()
						&& re.getString("TITLE").equals(c.getTitle())
						&& re.getString("DESCRIPTION").equals(c.getDescription())
						&& re.getString("IMAGE").equals(c.getImage()))
					throw new ExceptionName("The coupon already exist on data base");

			PreparedStatement p = con.prepareStatement(
					"insert into coupons (COMPANY_ID,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ");
			p.setInt(1, c.getCompanyId());
			p.setInt(2, c.getCategoryId());
			p.setString(3, c.getTitle());
			p.setString(4, c.getDescription());
			p.setDate(5, DateUtils.javaDateToSqlDate(c.getStartDate()));
			p.setDate(6, DateUtils.javaDateToSqlDate(c.getEndDate()));
			p.setInt(7, c.getAmount());
			p.setDouble(8, c.getPrice());
			p.setString(9, c.getImage());
			p.executeUpdate();
			System.out.println("insert coupons has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void delete(int couponID) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DELETE FROM coupons WHERE ID=" + couponID);
			System.out.println("delete from coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void update(Coupon c) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (re.next())
				if (re.getInt("COMPANY_ID") == c.getCompanyId() && re.getInt("CATEGORY_ID") == c.getCategoryId()
						&& re.getString("TITLE").equals(c.getTitle())
						&& re.getString("DESCRIPTION").equals(c.getDescription())
						&& re.getString("IMAGE").equals(c.getImage()))
					throw new ExceptionName("The coupon already exist on data base");

			con.createStatement()
					.executeUpdate("UPDATE coupons SET COMPANY_ID=" + c.getCompanyId() + ", CATEGORY_ID="
							+ c.getCategoryId() + ", TITLE='" + c.getTitle() + "', DESCRIPTION='" + c.getDescription()
							+ "', START_DATE='" + DateUtils.javaDateToSqlDate(c.getStartDate()) + "', END_DATE='"
							+ DateUtils.javaDateToSqlDate(c.getEndDate()) + "', AMOUNT=" + c.getAmount() + ", PRICE="
							+ c.getPrice() + ", IMAGE='" + c.getImage() + "' WHERE ID=" + c.getId());
			System.out.println("update coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCoupon() throws Exception {
		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>(); // try it = null
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (re.next()) {
				Category category = null;
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

	public Coupon getOneCoupon(int couponID) throws Exception {
		Connection con = null;
		Coupon c = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons where id=" + couponID);
			Category category = null;
			if (re.next()) {
				for (Category ca : Category.values())
					if (ca.ordinal() == re.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				c = new Coupon(re.getInt("ID"), re.getInt("COMPANY_ID"), category, re.getString("TITLE"),
						re.getString("DESCRIPTION"), re.getDate("START_DATE"), re.getDate("END_DATE"),
						re.getInt("AMOUNT"), re.getDouble("PRICE"), re.getString("IMAGE"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return c;
	}

	@Override
	public void addCouponPurchase(int customerId, int couponId) throws Exception {
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

	@Override
	public void deleteCouponPurchase(int customerId, int couponId) throws Exception {
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

}
