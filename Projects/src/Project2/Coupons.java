package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Coupons {
	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS coupons (ID INT(200) NOT NULL AUTO_INCREMENT ,"
				+ " COMPANY_ID int(10) NOT NULL REFERENCES companies(ID),"
				+ " CATEGORY_ID int(10) NOT NULL REFERENCES categories(ID),"
				+ " TITLE  VARCHAR(25) NOT NULL, DESCRIPTION TEXT DEFAULT NULL, START_DATE DATETIME,"
				+ " END_DATE DATETIME, AMOUNT INTEGER(200), PRICE FLOAT(30),IMAGE VARCHAR(20) ,PRIMARY KEY(ID) )");
		System.out.println("The table coupons has created");
	}

	public static void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE coupons");
		System.out.println("The table coupons is a drop");
	}

// add to insert foreign key
	public static void insert(String title, String text, Date startDate, Date endDate, Integer amount, float price,
			String image) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"insert into coupons (TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) values ('" + title
						+ "','" + text + "'," + startDate + "," + endDate + ",'" + amount + "'," + price + ",'" + image
						+ "')");
		System.out.println("insert coupons has succeed");
	}

	public static void delete(int indexToDelete) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DELETE FROM coupons WHERE ID=" + indexToDelete);
		System.out.println("delete from coupons has done");
	}

	// change double if can^
	// add foreign key
	public static void update(int companyId, int categoryId, String title, String text, Date startDate, Date endDate,
			Integer amount, float price, String image, int index) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement()
				.executeUpdate("UPDATE coupons SET TITLE='" + title + "',DESCRIPTION='" + text + "', START_DATE="
						+ startDate + ", END_DATE=" + endDate + ", AMOUNT=" + amount + ", PRICE=" + price + ", IMAGE='"
						+ image + "' WHERE ID=" + index);
		System.out.println("update coupons has done");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons");
		while (re.next())
			System.out.println("ID: " + re.getInt("ID") + " ,COMPANY_ID: " + re.getInt("COMPANY_ID") + " ,CATEGORY_ID: "
					+ re.getInt("CATEGORY_ID") + "TITLE: " + re.getInt("TITLE") + " ,DESCRIPTION: "
					+ re.getString("DESCRIPTION") + " ,START_DATE: " + re.getDate("START_DATE") + " ,END_DATE: "
					+ re.getDate("END_DATE") + " ,AMOUNT: " + re.getInt("AMOUNT") + " ,PRICE: " + re.getFloat("PRICE")
					+ " ,IMAGE: " + re.getString("IMAGE"));
	}
}
