package Day24_10_2018_Project2;

public class Alarm {
	private SimpleTime time;
	private boolean isSet;
	private int snoozeTime;
	private boolean isSnooze;

	// default constructor

	public Alarm() {
		this.time = new SimpleTime(0, 0, 0);
		this.isSet = false;
		this.snoozeTime = 0;
		this.isSnooze = false;
	}

	// regular constructor

	public Alarm(SimpleTime time, boolean isSet, int snoozeTime, boolean isSnooze) {
		this.time = time;
		this.isSet = isSet;
		this.snoozeTime = snoozeTime > 0 ? snoozeTime : 0;
		this.isSnooze = isSnooze;
	}

	// getter and setter

	public SimpleTime getTime() {
		return time;
	}

	public void setTime(SimpleTime time) {
		this.time = time;
	}

	public boolean getIsSet() {
		return isSet;
	}

	public void setSet(boolean isSet) {
		this.isSet = isSet;
	}

	public int getSnoozeTime() {
		return snoozeTime;
	}

	public void setSnoozeTime(int snoozeTime) {
		this.snoozeTime = snoozeTime > 0 ? snoozeTime : 0;
	}

	public boolean getIsSnooze() {
		return isSnooze;
	}

	public void setSnooze(boolean isSnooze) {
		this.isSnooze = isSnooze;
	}

	@Override
	public String toString() {
		return "Alarm [time=" + getTime() + ", isSet=" + getIsSet() + ", snoozeTime=" + getSnoozeTime() + ", isSnooze="
				+ getIsSnooze() + "]";
	}

}
