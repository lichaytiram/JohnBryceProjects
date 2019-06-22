package coupons.daily.job;

import java.util.Timer;
import java.util.TimerTask;

import coupons.exception.ApplicationException;

/**
 * This class create a timer
 * 
 * @author Lichay
 *
 */
public class MyTimer {

	/**
	 * This function create timer with task
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void createTimer() throws ApplicationException {

		// Creating a task
		TimerTask task = new MyTimerTask();

		// Creating a timer
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(task, 0, 1000);

		System.out.println("Timer task started");

	}

}