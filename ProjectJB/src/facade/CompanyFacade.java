package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbdao.CompaniesDBDAO;
import dbdao.ConnectionPool;
import dbdao.CouponsDBDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Company;
import javaBeans.Coupon;

public class CompanyFacade extends ClientFacade {

	private ConnectionPool connection = ConnectionPool.getInstance();
	private int companyID;

	public CompanyFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CompaniesDBDAO customer = new CompaniesDBDAO();
		try {
			this.companyID = customer.getOneCompanyByEmailAndPassword(email, password).getId();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	boolean login(String email, String password) {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		try {
			if (companies.isCompanyExists(email, password))
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public void addCoupon(Coupon c) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.insert(c);
	}

	public void updateCoupon(Coupon c) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.update(c);
	}

	public void deleteCoupon(int couponid) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.delete(couponid);
	}

	public ArrayList<Coupon> getCompanyCoupons() throws Exception {

		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons WHERE ID=" + companyID);
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

	public ArrayList<Coupon> getCompanyCoupons(Category category) throws Exception {

		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons WHERE ID=" + companyID);
			while (re.next()) {
				if (category.ordinal() == re.getInt("CATEGORY_ID"))
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

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws Exception {

		Connection con = null;
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons WHERE ID=" + companyID);

			while (re.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == re.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				if (re.getDouble("PRICE") < maxPrice)
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

	public Company getCompanyDetails() {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		try {
			return companies.getOneCompany(companyID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}