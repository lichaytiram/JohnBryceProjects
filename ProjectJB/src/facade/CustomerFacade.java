package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbdao.ConnectionPool;
import dbdao.CustomerDBDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Coupon;
import javaBeans.Customer;

public class CustomerFacade extends ClientFacade {

	private int customerID;
	private ConnectionPool connection = ConnectionPool.getInstance();

	public CustomerFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			this.customerID = customer.getOneCustomerByEmailAndPassword(email, password).getId();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	boolean login(String email, String password) {
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			if (customer.isCustomerExists(email, password))
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public void purchaseCoupon(Coupon coupon) throws Exception {

	}

	
	public ArrayList<Coupon> getCustomerCoupons() throws Exception {

		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + customerID);
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

	public ArrayList<Coupon> getCustomerCoupons(Category category) throws Exception {

		return null;
	}

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws Exception{

		return null;
	}

	public Customer getCustomerDetails() {
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			return customer.getOneCustomer(customerID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}