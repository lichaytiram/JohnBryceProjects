package BaseProgram;

import Exception.ExceptionName;

public class mainDemo {
	public static void main(String[] args) {

		try {
			Company c1 = new Company(123, "1w23X", "wx@s.d", "7x");
			Customer cu1 = new Customer(5, "45sD64", "lichay@s.c", "lichay", "soos");
			System.out.println(c1);
			System.out.println(cu1);
//			c1.getCouponList().add(new Coupon());
//			c1.getCouponList().add(new Coupon());
			System.out.println(c1);
		} catch (ExceptionName e) {
			System.out.println(e);
		}

	}
}
