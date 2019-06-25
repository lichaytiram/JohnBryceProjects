package coupons.daily.job;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coupons.dao.ICouponsDao;

/**
 * This function create a thread class for delete expired coupons
 * 
 * @author Lichay
 *
 */
@Component
public class MyTimerTask extends TimerTask {

	@Autowired
	private ICouponsDao couponsDao;

	@Override
	public void run() {

		couponsDao.deleteExpiredCoupon();

	}

}