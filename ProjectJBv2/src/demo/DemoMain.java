package demo;

import java.util.Date;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import beans.User;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.CustomerDao;
import dao.PurchasesDao;
import dao.UsersDao;
import enums.Category;
import enums.ClientType;
import exception.ApplicationException;
import test.RefreshDataBase;

public class DemoMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		RefreshDataBase refreshDataBase = new RefreshDataBase();
		refreshDataBase.refreshDB();

		Date startDate = new Date();
		Date endDate = new Date();
		endDate.setYear(startDate.getYear() + 1);

		CompaniesDao company = new CompaniesDao();
		CustomerDao customer = new CustomerDao();
		CouponsDao coupon = new CouponsDao();
		UsersDao user = new UsersDao();
		PurchasesDao purchases = new PurchasesDao();

		try {
			company.createCompany(new Company("sS2PASS", "www.g@gmail.com", "company1"));
			company.createCompany(new Company("sS2", "www.g@gmail.com", "company2"));
			System.out.println(company.getAllCompany());
			System.out.println(company.isCompanyExists("www.g@gmail.com", "sS2"));
			System.out.println(company.isCompanyExists(2));
			System.out.println(company.getCompany(2));
			System.out.println(company.getCompanyByEmailAndPassword("www.g@gmail.com", "sS2PASS"));
			System.out.println(customer.getAllCustomer());
			System.out.println(customer.getCustomer(1));
			System.out.println(customer.getCustomerByEmailAndPassword("email@gmail.coms", "password1Ss"));
			System.out.println(customer.isCustomerExists(1));
			System.out.println(customer.isCustomerExists("email@gmail.coms", "passwosrd1Ss"));
//			customer.deleteCustomer(1);
			coupon.createCoupon(new Coupon(1, Category.Food, "f1", "d1", startDate, endDate, 2, 21, "hi.gmail"));
			coupon.createCoupon(new Coupon(1, Category.Weapon, "f2", "d2", startDate, endDate, 15, 100, "hi.gmail"));
			coupon.createCoupon(new Coupon(2, Category.Electricity, "f3", "d3", startDate, endDate, 2, 23, "hi.gmail"));
			System.out.println("----------");
			System.out.println(coupon.getAllCoupon());
			System.out.println(coupon.getCompanyCouponsById(1));
			System.out.println(coupon.getCompanyCouponsByMaxPrice(900, 1));
			System.out.println("----------");
			System.out.println(coupon.getCompanyCouponsByCategory(Category.Electricity, 2));
			user.createUser(new User("li", "s1", null, ClientType.Customer));
			user.createUser(new User("li", "s2", 1L, ClientType.Company));
			user.createUser(new User("li", "s3", 2L, ClientType.Company));
			user.createUser(new User("li", "s4", null, ClientType.Administrator));
			user.createUser(new User("li", "s5", null, ClientType.Customer));
			user.createUser(new User("li", "s6", null, ClientType.Customer));
			customer.createCustomer(new Customer(1, "S1s", "s@gmail.com", "li", "tiram"));
			customer.createCustomer(new Customer(2, "S1s", "s@gmail.com", "li", "tiram"));
			customer.createCustomer(new Customer(5, "S1s", "s@gmail.com", "li", "tiram"));
			customer.createCustomer(new Customer(6, "S1s", "s@gmail.com", "li", "tiram"));
			purchases.purchaseCoupon(1, 2, 2);
			purchases.purchaseCoupon(1, 2, 3);
			purchases.purchaseCoupon(5, 2, 5);
			purchases.purchaseCoupon(1, 1, 1);
			System.out.println(purchases.getAmount(1));
			System.out.println(purchases.isCustomerBought(2));
			System.out.println(purchases.isCustomerBought(5, 2));
			System.out.println(purchases.getCustomerCouponByCustomerId(1));
			System.out.println(purchases.getCustomerCouponByCategory(1, Category.Weapon));
			System.out.println(purchases.getCustomerCouponByMaxPrice(1, 21));
			purchases.refundCoupon(1, 2);
			
			

		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("-new lane-");
//		System.out.println(Name.go);
	}
}

// try enum
enum Name {
	pop("this is pop"), go("this is go");

	Name(String name) {

	}
}
