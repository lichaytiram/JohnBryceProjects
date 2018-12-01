package page51;

public class try5 {
	public static void main(String[] args) {
		int hour = 23, min = 59, sec = 58, count = 0;
		System.out.println("Start-> [" + hour + "," + min + "," + sec + "]");
		int hourS = 0, minS = 0, secS = 2;
		System.out.println("End---> [" + hourS + "," + minS + "," + secS + "]");
		while (hour != hourS || min != minS || sec != secS) {
			count++;
			if (sec < 59) {
				sec += 1;
			} else if (min < 59) {
				sec = 0;
				min++;
			} else if (hour < 23) {
				hour++;
				min = 0;
				sec = 0;
			} else {
				hour = 0;
				min = 0;
				sec = 0;
			}

		}
		System.out.println("The end is-> [" + hour + "," + min + "," + sec + "] --->> " + count + " sec");

	}
}
