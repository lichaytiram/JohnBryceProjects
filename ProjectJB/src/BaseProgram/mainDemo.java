package BaseProgram;

import Exception.ExceptionName;

public class mainDemo {
	public static void main(String[] args) {

		try {
			Company c = new Company(123, "12x3X", "wx@s.d", "7x");
			System.out.println(c);
			c.getCouponList().add(new Coupon());
			c.getCouponList().add(new Coupon());
			System.out.println(c);
		} catch (ExceptionName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
