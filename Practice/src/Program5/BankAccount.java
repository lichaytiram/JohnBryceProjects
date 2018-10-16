package Program5;

public class BankAccount {

	private int no; // account number
	private Person owner; // account owner
	private double balance; // account balance

// trivial constructor
// use deep copy for owner
// set balance to zero
	public BankAccount(int no, Person owner) {
		this.no = no;
		this.owner = new Person(owner);
		this.balance = 0;
	}

	// account number getter
	public int getNo() {
		return no;
	}

	// account owner getter
	// use deep copy
	public Person getOwner() {
		return new Person(owner);

	}

	// account balance getter
	public double getBalance() {
		return balance;
	}

	// owner name changer
	public void changeName(Name name) {
		this.owner.changeName(name);

	}

	// owner address changer
	public void changeAddress(Address address) {
		this.changeAddress(address);
	}

	// execute a transaction – withdrawal or deposit
	// call private function as necessary
	// assume amount is positive
	// return if the execution succeeded
	public boolean execute(Transaction trans) {
		String kind = trans.getKind();
		if (kind.equals("Deposit")) {
			depose(trans.getAmount());
			return true;
		} else if (kind.equals("Withdrawal"))
			return withdrawal(trans.getAmount());

		return false;
	}

	// depose the amount
	// always succeeded
	private void depose(double amount) {
		balance += amount;
	}

	// withdrawal the amount
	// no overdraft allowed
	// if balance too low skip the operation and return false
// otherwise execute and return true
	private boolean withdrawal(double amount) {
		if (balance < amount)
			return false;
		else
			balance -= amount;
		return true;
	}

	// get account status
	public AccountStatus getStatus() {
		return new AccountStatus(no, owner, balance);

	}

	@Override
	public String toString() {
		return "BankAccount [no=" + no + ", owner=" + owner + ", balance=" + balance + "]";
	}

	public boolean equals(Object x) {
		if (x instanceof BankAccount)
			return true;
		return false;
	}
}
