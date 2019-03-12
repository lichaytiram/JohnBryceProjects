package demo;

import java.util.Date;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dbdao.CompaniesDao;
import dbdao.CouponsDao;
import dbdao.CustomerDao;
import exception.ExceptionName;
import test.RefreshDataBase;

public class DemoMain {

	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Class.forName(Driver);
		} catch (Exception e) {
			System.out.println(e);
		}
		RefreshDataBase refreshDataBase = new RefreshDataBase();
		refreshDataBase.refreshDB();

		Date startDate = new Date();
		Date endDate = new Date();
		endDate.setYear(startDate.getYear() + 1);

		CompaniesDao company = new CompaniesDao();
		CustomerDao customer = new CustomerDao();
		CouponsDao coupon = new CouponsDao();
		try {
			company.insert(new Company("sS2PASS", "www.g@gmail.com", "company1"));
			company.insert(new Company("sS2", "www.g@gmail.com", "company2"));
			System.out.println(company.getAllCompany());
			System.out.println(company.isCompanyExists("www.g@gmail.com", "sS2"));
			System.out.println(company.isCompanyExists(2));
			System.out.println(company.getCompany(2));
			System.out.println(company.getCompanyByEmailAndPassword("www.g@gmail.com", "sS2PASS"));
			customer.insert(new Customer("password1S", "email@gmail.com", "firstName", "lastName"));
			customer.insert(new Customer("password1Ss", "email@gmail.coms", "firstNames", "lastNames"));
			System.out.println(customer.getAllCustomer());
			System.out.println(customer.getCustomer(1));
			System.out.println(customer.getCustomerByEmailAndPassword("email@gmail.coms", "password1Ss"));
			System.out.println(customer.isCustomerExists(1));
			System.out.println(customer.isCustomerExists("email@gmail.coms", "passwosrd1Ss"));
			customer.delete(1);
			coupon.insert(new Coupon(1, Category.Food, "f1", "d1", startDate, endDate, 2, 21, "hi.gmail"));
			coupon.insert(new Coupon(1, Category.Comicsý, "f2", "d2", startDate, endDate, 2, 100, "hi.gmail"));
			coupon.insert(new Coupon(2, Category.Electricity, "f3", "d3", startDate, endDate, 2, 23, "hi.gmail"));
			System.out.println(coupon.getAllCoupon());
			System.out.println(coupon.getCompanyCouponsById(2));
			System.out.println(coupon.getCompanyCouponsByMaxPrice(900, 1));
			System.out.println("----------");
			System.out.println(coupon.getCompanyCouponsByCategory(Category.Electricity, 2));

		} catch (ExceptionName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
