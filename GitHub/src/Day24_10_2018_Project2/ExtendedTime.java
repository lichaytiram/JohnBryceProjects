package Day24_10_2018_Project2;
             
public class ExtendedTime extends SimpleTime {
	private boolean is24Hours;

	// default constructor

	public ExtendedTime() {
		super(0, 0, 0);
		this.is24Hours = true;
	}

	// regular constructor

	public ExtendedTime(int hour, int minute, int second, boolean is24Hours) {
		super(hour, minute, second);
		this.is24Hours = is24Hours;
	}

	// getter and setter

	public boolean isIs24Hours() {
		return is24Hours;
	}

	public void setIs24Hours(boolean is24Hours) {
		this.is24Hours = is24Hours;
	}

	// print

	@Override
	public String toString() {
		if (this.is24Hours)
			return super.toString();
		else
			return print12Hours();
	}

	public String print12Hours() {
		String isMiddle;
		if (this.getHour() > 12 || this.getHour() == 0)
			isMiddle = "PM";
		else
			isMiddle = "AM";
		int tempHour = getHour();
		tempHour = (tempHour > 12) ? tempHour - 12 : tempHour;
		return "[" + tempHour + ":" + getMinute() + ":" + getSecond() + "] " + isMiddle;
	}

}
