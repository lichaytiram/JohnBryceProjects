package bankaccount;

public class Bank {
	double balance;
	double commission;
	String owner;

	public Bank(double balance, double commission, String owner) {
		this.balance = balance;
		this.commission = commission;
		this.owner = owner;
	}

	public void deposite(double amount) {
		balance += amount - commission;
	}

	public void withdraw(double amount) {
		if (0 <= balance - amount - commission)
			balance -= amount - commission;
		else
			System.out.println("no money");
	}

	public String toString() {
		return "balance " + balance + " commission " + commission + " owner " + owner;
	}
}
