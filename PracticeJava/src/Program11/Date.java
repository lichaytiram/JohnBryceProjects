package Program11;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = (day >= 0 && day <= 30) ? day : 0;
		this.month = (month >= 0 && month <= 12) ? month : 0;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}
