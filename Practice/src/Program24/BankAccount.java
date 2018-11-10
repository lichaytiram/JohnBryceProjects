package Program24;

public class BankAccount {
	private Person person;
	private double balance;

	public BankAccount(Person person) {
		super();
		this.balance = 0;
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void deposite(double money) {
		balance += money;
	}

	public void withdraw(double money) {
		balance -= money;
	}

	@Override
	public String toString() {
		return "BankAccount [" + person + ", balance=" + balance + "]";
	}

}
