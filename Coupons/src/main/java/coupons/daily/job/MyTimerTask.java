package coupons.daily.job;

import java.util.TimerTask;

import coupons.exception.ApplicationException;
import coupons.logic.CouponController;

/**
 * This function create a thread class for delete expired coupons
 * 
 * @author Lichay
 *
 */
public class MyTimerTask extends TimerTask {

	private CouponController couponController;

	/**
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public MyTimerTask() throws ApplicationException {

		couponController = new CouponController();

	}

	@Override
	public void run() {

		try {

			couponController.deleteExpiredCoupon();

		} catch (ApplicationException e) {

			e.printStackTrace();

		}

	}

}