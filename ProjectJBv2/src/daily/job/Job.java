package daily.job;

import java.util.List;

import dao.CouponsDao;
import enums.ErrorType;
import exception.ApplicationException;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (true) {

			try {
				synchronized (coupon.getAllexpiredCouponsId()) {
					List<Integer> list = coupon.getAllexpiredCouponsId();
					while (list.size() > 0) {
						// need add all check..
						coupon.deleteCoupon(list.get(0));
						System.out.println("coupon id= [" + list.get(0) + "] has been deleted");
						list.remove(0);
					}
				}
				Thread.sleep(1000 * 60 * 60 * 24);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * This function to stop this daily job
	 * 
	 * @throws ApplicationException
	 */
	public void stop() throws ApplicationException {
		try {
			System.out.println("Daily job has stopped");
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		}
	}

}
