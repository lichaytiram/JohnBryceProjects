package Day24_10_2018_Project1;

public class TestBankAccount {
	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		System.out.println(b1);
		b1.setOverDraftAllowed();
		b1.setOverDraftSum(2000);
		System.out.println(b1);
		b1.deposit(10000);
		System.out.println(b1);
		b1.withdrawal(50000);
		System.out.println(b1);
		b1.withdrawal(50);
		System.out.println(b1);
		b1.setOverDraftSum(200);
		b1.withdrawal(500);
		System.out.println(b1);
		b1.deposit(1900);
		System.out.println();
		System.out.println(b1);
		b1.withdrawal(50);
		System.out.println(b1);
		b1.setOverDraftAllowed();
		System.out.println(b1);
		b1.withdrawal(30);
		System.out.println(b1);
		// all option can be
	}
}
