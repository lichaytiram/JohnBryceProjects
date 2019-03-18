package daily.job;

import java.util.ArrayList;

import dao.CouponsDao;

/**
 * 
 * This class create a daily job for check about coupons expired date
 * 
 * @author Lichay
 *
 */
public class Job implements Runnable {

	/**
	 * Constructor for create a show
	 */
	public Job() {
		System.out.println("Daily job is running!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (true) {
			CouponsDao coupon = new CouponsDao();

			try {
				synchronized (coupon.getAllexpiredCouponsId()) {
					ArrayList<Integer> list = coupon.getAllexpiredCouponsId();
					while (list.size() > 0) {
						coupon.deleteCoupon(list.get(0));
						System.out.println("coupon id= [" + list.get(0) + "] has been deleted");
						list.remove(0);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			try {
				Thread.sleep(1000 * 60 * 60 * 24);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * This function to stop this daily job
	 */
	public void stop() {
		try {
			System.out.println("Daily job has stopped");
			wait();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
