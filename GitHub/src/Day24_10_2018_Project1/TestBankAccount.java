package Day24_10_2018_Project1;

public class TestBankAccount {
	public static void main(String[] args) {

		// Account 1
		BankAccount b1 = new BankAccount();
		System.out.println(b1);
		b1.setOverDraftSum(200);
		System.out.println(b1.withdrawal(500));
		System.out.println(b1);
		b1.deposit(1900);
		System.out.println(b1);
		b1.withdrawal(50);
		System.out.println(b1);
		b1.setOverDraftAllowed();
		System.out.println(b1);
		b1.withdrawal(30);
		System.out.println(b1);
		// all option can be

		// Account 2
		System.out.println();
		BankAccount b2 = new BankAccount("Doron", "ab123456", true, 5000);
		System.out.println(b2);
		b2.deposit(100000);
		System.out.println(b2.withdrawal(1500));
		System.out.println(b2);
		System.out.println(b2.withdrawal(102000));
		System.out.println(b2);
		System.out.println(b2.withdrawal(200));
		System.out.println(b2);
	}
}
