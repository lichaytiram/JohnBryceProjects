package Day24_10_2018_Project2;

public class SimpleTime {
	private int hour;
	private int minute;
	private int second;

	public SimpleTime() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}

	public SimpleTime(int hour, int minute, int second) {
		this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
		this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
		this.second = (second >= 0 && second <= 59) ? second : 0;
	}

}
