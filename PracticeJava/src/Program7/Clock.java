package Program7;

public class Clock {
	private int sec;
	private int minute;
	private int hour;

	public Clock(int sec, int minute, int hour) {
		this.sec = sec;
		this.minute = minute;
		this.hour = hour;
	}

	public void tick() {
		if (sec < 59)
			sec++;
		else if (minute < 59) {
			minute++;
			sec = 0;
		} else if (hour < 23) {
			hour++;
			minute = 0;
			sec = 0;
		} else {
			hour = 0;
			minute = 0;
			sec = 0;
		}

	}

	public void reset() {
		hour = 0;
		minute = 0;
		sec = 0;

	}

	public String show() {
		return "Clock [sec=" + sec + ", minute=" + minute + ", hour=" + hour + "]";
	}
}
