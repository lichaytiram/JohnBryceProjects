package Day24_10_2018_Project2;

public class SimpleTime {
	private int hour;
	private int minute;
	private int second;

	// default constructor

	public SimpleTime() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}
	// regular constructor

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

	public void add(SimpleTime time) {
		addHour(time.getHour());
		addMinute(time.getMinute());
		addSecond(time.getSecond());
	}

	public void addHour(int hour) {
		while (hour > 0) {
			if (this.hour <= 22)
				this.hour++;
			else
				this.hour = 0;
			hour--;
		}
	}

	public void addMinute(int minute) {

		while (minute > 0) {
			if (this.minute <= 58)
				this.minute++;
			else {
				this.minute = 0;
				addHour(1);
			}
			minute--;
		}
	}

	public void addSecond(int second) {
		while (second > 0) {
			if (this.second <= 58)
				this.second++;
			else {
				this.second = 0;
				addMinute(1);
			}
			second--;
		}
	}

	public void tick() {
		addSecond(1);
	}

	public boolean equalss(Object object) {
		if (object instanceof SimpleTime) {
			SimpleTime temp = ((SimpleTime) object);
			if (this.getHour() == temp.getHour() && this.getMinute() == temp.getMinute()
					&& this.getSecond() == temp.getSecond())
				return true;
		}
		return false;
	}

	// print

	@Override
	public String toString() {
		return "[" + getHour() + ":" + getMinute() + ":" + getSecond() + "]";
	}

}
