package javaBeans;

import java.util.Date;

import exception.ExceptionName;

public class mainDemo {
	public static void main(String[] args) {

		try {
			Company c1 = new Company(123, "1w23X", "wx@s.d", "7x");
			Customer cu1 = new Customer(5, "45sD64", "lichay@s.c", "lichay", "soos");
			Coupon cou = new Coupon(1, 1, Category.Food, "aa", "", new Date(), new Date(), 30, 30.4, "fileH.html");
			System.out.println(c1);
			System.out.println(cu1);
			c1.getCouponList().add(cou);
			c1.getCouponList().add(cou);
			System.out.println(c1);
		} catch (ExceptionName e) {
			System.out.println(e);
		}
	}
}
