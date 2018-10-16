package class3;

public class Money {
	int dollars, cents;

	public void setMoney(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}

	public Money(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}

	public void add(double d) {
		int dollarsX = (int) d;
		double centsX = (d - dollarsX) * 100;
		System.out.println();
		if (this.cents + centsX < 100)
			this.cents += centsX;
		else {
			this.dollars += 1;
			this.cents = 100 - (int) centsX;
		}
		this.dollars += dollarsX;
	}

	public String toString() {
		return "Money [" + dollars + "." + cents + "$]";
	}
}
