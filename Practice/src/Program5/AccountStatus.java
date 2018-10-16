package Program5;

import java.util.Date;

public class AccountStatus {

	private Date date; // report date
	private int reportNo; // report number
	private Person owner; // the owner of the account
	private double balance; // account balance

	// trivial constructor
	// get date from system: “date = new Date();”
	public AccountStatus(int no, Person owner, double balance) {
		this.date = new Date();
		this.owner = owner;
		this.balance = balance;
		this.reportNo = no;
	}

	public String toString() {
		return "AccountStatus [date=" + date + ", reportNo=" + reportNo + ", owner=" + owner + ", balance=" + balance
				+ "]";
	}

	public boolean equals(Object x) {
		if (x instanceof AccountStatus)
			return true;
		return false;
	}
}
