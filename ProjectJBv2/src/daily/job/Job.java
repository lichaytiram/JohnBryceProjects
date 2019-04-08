package daily.job;

import dao.CouponsDao;

/**
 * 
 * This class create a daily job for check about coupons expired date
 * 
 * @author Lichay
 *
 */
public class Job implements Runnable {

	private CouponsDao coupon;

	/**
	 * Constructor for create a show
	 */
	public Job() {
		coupon = new CouponsDao();
		System.out.println("Daily job is running!");
	}

	@Override
	public void run() {

		while (true) {

			try {
				System.out.println(coupon); // nothing
//				synchronized (coupon.getAllexpiredCouponsId()) {
//					List<Integer> list = coupon.getAllexpiredCouponsId();
//					while (list.size() > 0) {
//						// need add all check..
//						coupon.deleteCoupon(list.get(0));
//						System.out.println("coupon id= [" + list.get(0) + "] has been deleted");
//						list.remove(0);
//					}
//				}

				Thread.sleep(1000 * 60 * 60 * 24);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
