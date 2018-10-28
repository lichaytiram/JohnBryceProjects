package Day24_10_2018_Project2;

public class AlarmClock {
	private ExtendedTime currentTime;
	private Alarm alarm;
	private int sumOfTimeToAlarm;

	// Default Constructor

	public AlarmClock() {
		this.alarm = new Alarm();
		this.currentTime = new ExtendedTime();
		this.sumOfTimeToAlarm = 1;

	}

	// getter and setter

	public ExtendedTime getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(ExtendedTime currentTime) {
		this.currentTime = currentTime;
	}

	// methods

	public void setAlarm(int sumOfTimeToAlarm, Alarm alarm) {
		this.sumOfTimeToAlarm = sumOfTimeToAlarm;
		this.alarm = alarm;

	}

	public void setAlarm(int hour, int minute, int second) {
		this.alarm = new Alarm(new SimpleTime(hour, minute, second), true, 0, false);
	}

	@Override
	public String toString() {
		if (this.currentTime.getHour() == alarm.getTime().getHour()
				&& this.currentTime.getMinute() == alarm.getTime().getMinute()
				&& this.currentTime.getSecond() == alarm.getTime().getSecond() && alarm.getIsSet())
			return "AlarmClock [bZzZzZzZz..] " + sumOfTimeToAlarm + "-times";
		else
			return "";
	}

}
