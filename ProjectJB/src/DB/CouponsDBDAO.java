package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

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
							+ " END_DATE TIMESTAMP , AMOUNT int(200) UNSIGNED, PRICE DOUBLE PRECISION UNSIGNED,IMAGE VARCHAR(20) ,PRIMARY KEY(ID) )");
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

	// try fix date -->

//	public void insert(int companyId, int categoryId, String title, String text, Date startDate, Date endDate,
//			int amount, double price, String image) throws Exception {
//
//		Connection con = null;
//		try {
//			con = connection.getConnection();
//
//			PreparedStatement p = (PreparedStatement) con.prepareStatement(
//					"insert into coupons (COMPANY_ID,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) values ( ? , ? , ? , ? , ? , ? , ? , ? ,?)");
//			p.setInt(1, companyId);
//			p.setInt(2, categoryId);
//			p.setString(3, title);
//			p.setString(4, text);
//			p.setDate(5, startDate);
//			p.setDate(6, endDate);
//			p.setInt(7, amount);
//			p.setDouble(8, price);
//			p.setString(9, image);
//
//			System.out.println("insert coupons has succeed");
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			connection.restoreConnection(con);
//		}
//	}

//	 copy work, well 
	public void insert(int companyId, int categoryId, String title, String text, Date startDate, Date endDate,
			int amount, double price, String image) throws Exception {
		LocalDate localdate = LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDay());
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"insert into coupons (COMPANY_ID,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) values ("
							+ companyId + "," + categoryId + ",'" + title + "','" + text + "'," + localdate + ","
							+ localdate + "," + amount + "," + price + ",'" + image + "')");
			System.out.println("insert coupons has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void delete(int indexToDelete) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DELETE FROM coupons WHERE ID=" + indexToDelete);
			System.out.println("delete from coupons has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	// try fix date
	public void update(int companyId, int categoryId, String title, String text, Date startDate, Date endDate,
			int amount, double price, String image, int index) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement()
					.executeUpdate("UPDATE coupons SET COMPANY_ID=" + companyId + ", CATEGORY_ID=" + categoryId
							+ ", TITLE='" + title + "', DESCRIPTION='" + text + "', START_DATE=" + startDate
							+ ", END_DATE=" + endDate + ", AMOUNT=" + amount + ", PRICE=" + price + ", IMAGE='" + image
							+ "' WHERE ID=" + index);
			System.out.println("update coupons has done");
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
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons");
			while (re.next())
				System.out.println("ID: " + re.getInt("ID") + " ,COMPANY_ID: " + re.getInt("COMPANY_ID")
						+ " ,CATEGORY_ID: " + re.getInt("CATEGORY_ID") + "TITLE: " + re.getString("TITLE")
						+ " ,DESCRIPTION: " + re.getString("DESCRIPTION") + " ,START_DATE: " + re.getDate("START_DATE")
						+ " ,END_DATE: " + re.getDate("END_DATE") + " ,AMOUNT: " + re.getInt("AMOUNT") + " ,PRICE: "
						+ re.getDouble("PRICE") + " ,IMAGE: " + re.getString("IMAGE"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}
}
