package Program24;

import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bank;

	public Bank() {
		super();
		bank = new ArrayList<BankAccount>();
	}

	public void addCustomer(BankAccount bankAccount) {
		bank.add(bankAccount);
	}

	@Override
	public String toString() {
		return "[bank=" + bank + "]";
	}

}
