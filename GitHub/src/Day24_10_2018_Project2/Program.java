package Day24_10_2018_Project2;

public class Program {
	public static void main(String[] args) {

		// first check options
		SimpleTime t1 = new SimpleTime(23, 24, 50);
		SimpleTime t2 = new SimpleTime(0, 0, 1);
		System.out.println(t1);
		t1.addSecond(12);
		System.out.println(t1);
		t1.addMinute(40);
		System.out.println(t1);
		t1.tick();
		System.out.println(t1);
		t1.add(t2);
		System.out.println(t1 + "\n");
		SimpleTime t3 = new SimpleTime(0, 5, 4);
		System.out.println(t1);
		System.out.println(t3);
		System.out.println(t1.equalss(t3));
		ExtendedTime e = new ExtendedTime(12, 2, 2, false);
		System.out.println();
		System.out.println(e);

		// second check options - Alarm
		
		AlarmClock a1 = new AlarmClock();
		
		a1.setAlarm(0, 0, 0);
		System.out.println(a1);
	}
}
