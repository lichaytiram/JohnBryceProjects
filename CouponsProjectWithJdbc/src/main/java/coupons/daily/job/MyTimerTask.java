package coupons.daily.job;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coupons.exception.ApplicationException;
import coupons.logic.CouponController;

/**
 * This function create a thread class for delete expired coupons
 * 
 * @author Lichay
 *
 */
@Component
public class MyTimerTask extends TimerTask {

	@Autowired
	private CouponController couponController;

	@Override
	public void run() {

		try {

			couponController.deleteExpiredCoupons();

		} catch (ApplicationException e) {

			e.printStackTrace();

		}

	}

}