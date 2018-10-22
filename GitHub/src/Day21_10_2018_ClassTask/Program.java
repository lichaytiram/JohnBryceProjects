package Day21_10_2018_ClassTask;

public class Program {
	public static IFly createIFly() {
		int r = (int) (Math.random() * 3);
		if (r == 0)
			return new Bird();
		else if (r == 1)
			return new Pilot();
		return new Kite();
	}

	public static void main(String[] args) {
		IFly[] ifly = new IFly[10];
		for (int i = 0; i < ifly.length; i++) {
			ifly[i] = createIFly();
		}
		System.out.println();
		for (IFly temp : ifly) {
			temp.fly(10);
			System.out.println(temp.land());
			System.out.println();
		}
	}
}
