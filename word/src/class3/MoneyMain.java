package class3;

public class MoneyMain {
	public static void main(String[] args) {
		Money m1 = new Money(50, 30);
		System.out.println(m1);
		m1.setMoney(100, 50);
		System.out.println(m1);
		m1.add(8.1);
		System.out.println(m1);
	}
}
