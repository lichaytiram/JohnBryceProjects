package Day24_10_2018_Project1;

public class BankAccount {
	private String accountName;
	private final String accountNum;
	private double balance;
	private boolean isOverDraftAllowed;
	private double overDraftSum;

	// constructor default
	public BankAccount() {
		this.accountName = "Account";
		this.accountNum = "000001";
		this.balance = 0;
		this.isOverDraftAllowed = false;
		this.overDraftSum = 0;
	}

	// constructor regular
	public BankAccount(String accountName, String accountNum, boolean isOverDraftAllowed, double overDraftSum) {
		this.accountName = accountName;
		this.accountNum = accountNum;
		this.balance = 0;
		this.isOverDraftAllowed = isOverDraftAllowed;
		this.overDraftSum = isOverDraftAllowed ? overDraftSum : 0;

	}

	// setter and getter

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public boolean getIsOverDraftAllowed() {
		return isOverDraftAllowed;
	}

	public void setOverDraftAllowed() {
		this.isOverDraftAllowed = !isOverDraftAllowed;
		this.overDraftSum = 0;
	}

	public double getOverDraftSum() {
		return overDraftSum;
	}

	public void setOverDraftSum(double overDraftSum) {
		if (isOverDraftAllowed)
			this.overDraftSum = overDraftSum;
		else
			System.out.println("overDraftSum isn't allow");
	}

	public String getAccountNum() {
		return accountNum;
	}

	public double getBalance() {
		return balance;
	}

	// methods
	public void deposit(double money) {
		this.balance += money > 0 ? money : 0;
	}

	public void withdrawal(double money) {
		money = money > 0 ? money : 0;
		if (balance >= money) {
			balance -= money;
			System.out.println("action has succeed");
		} else if (getOverDraftSum() + balance >= money) { // if getOverDraftSum() is false -> getOverDraftSum() = 0
			balance -= money;
			System.out.println("action has succeed");
			System.out.println("You in overdraft in your account");
		} else if (balance > -getOverDraftSum()) {
			balance += -(balance + getOverDraftSum());
			System.out.println("action has succeed");
			if (getIsOverDraftAllowed())
				System.out.println("You in overdraft in your account");
		}else
			System.out.println("no money to withdrawal\nYou in overdraft in your account");

	}

	// print
	@Override
	public String toString() {
		return "BankAccount [accountName=" + accountName + ", accountNum=" + accountNum + ", balance=" + balance
				+ ", isOverDraftAllowed=" + isOverDraftAllowed + ", overDraftSum=" + overDraftSum + "]";
	}

}
