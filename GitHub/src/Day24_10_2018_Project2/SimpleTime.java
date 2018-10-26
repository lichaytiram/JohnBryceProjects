package Day24_10_2018_Project2;

public class SimpleTime {
	private int hour;
	private int minute;
	private int second;

	// constructor default

	public SimpleTime() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}
	// constructor regular

	public SimpleTime(int hour, int minute, int second) {
		this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
		this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
		this.second = (second >= 0 && second <= 59) ? second : 0;
	}

	// getter and setter

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = (second >= 0 && second <= 59) ? second : 0;
	}

	// methods

	public void setTime(int hour, int minute, int second) {
		this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
		this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
		this.second = (second >= 0 && second <= 59) ? second : 0;
	}
	
	

	@Override
	public String toString() {
		return "SimpleTime [hour=" + getHour() + ", minute=" + getMinute() + ", second=" + getSecond() + "]";
	}

}
