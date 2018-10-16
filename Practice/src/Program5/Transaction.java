package Program5;

public class Transaction {
	

	private String kind; // transaction kind. “Deposit” or “Withdrawal”
	private double amount; // transaction amount

	// trivial constructor
	// assume amount is positive
	public Transaction(int id, String kind, double amount) {
		this.kind = kind;
		this.amount = amount;
/////////////????????????;
	}

	// transaction kind getter
	public String getKind() {
		return kind;
	}

	// transaction amount getter
	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction [kind=" + kind + ", amount=" + amount + "]";
	}

	public boolean equals(Object x) {
		if (x instanceof Transaction)
			return true;
		return false;

	}
}
