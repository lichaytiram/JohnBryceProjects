package coupons.daily.job;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Repository;

import coupons.exception.ApplicationException;

@Repository
public class MyTimer {

	public MyTimer() throws ApplicationException {

		createTimer();

	}

	public static void createTimer() throws ApplicationException {

		// Creating a task
		TimerTask task = new MyTimerTask();

		// Creating a timer
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(task, 0, 1000);

		System.out.println("Timer task started");

	}

}