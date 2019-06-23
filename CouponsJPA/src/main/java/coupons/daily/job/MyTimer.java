package coupons.daily.job;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import coupons.exception.ApplicationException;

/**
 * This class create a timer
 * 
 * @author Lichay
 *
 */
@Component
public class MyTimer {

	/**
	 * This function create timer with task
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostConstruct
	public static void createTimer() throws ApplicationException {

		// Creating a task
		TimerTask task = new MyTimerTask();

		// Creating a timer
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(task, 0, 1000);

		System.out.println("Timer task started");

	}

}