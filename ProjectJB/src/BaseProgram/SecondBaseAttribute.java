package BaseProgram;

import java.util.ArrayList;
import Exception.ExceptionName;

public abstract class SecondBaseAttribute extends BaseAttribute {

	// properties

	private String password;
	private String email;
	private ArrayList<Coupon> CouponList;

	// constructor

	public SecondBaseAttribute(int id, String password, String email) throws ExceptionName {
		super(id);
		setPassword(password);
		setEmail(email);
		CouponList = new ArrayList<>();
	}

	// getter & setter

	// fix show list
	public ArrayList<Coupon> getCouponList() {
		return CouponList;
	}

	// after Coupon finish
	public void setCouponList(Coupon couponList) {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws ExceptionName {
		if (checkPassword(password))
			this.password = password;
		else
			throw new ExceptionName("The password must contain one digit , one big letter and one small letter");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws ExceptionName {

		if (!email.contains("@"))
			throw new ExceptionName("Your email invalid (isn't contain <@>)");
		else if (!(email.indexOf('@') + 1 < email.lastIndexOf('.')))
			throw new ExceptionName("Your email invalid (isn't contain <.> after <@> one letter at least)");
		else
			this.email = email;
	}

	// functions

	private boolean checkPassword(String password) {
		if (password == null)
			return false;
		if (password.isEmpty())
			return false;
		char checkLetter = 'a';
		while (checkLetter <= 'z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'z')
				return false;
			checkLetter++;
		}
		checkLetter = 'A';
		while (checkLetter <= 'Z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'Z')
				return false;
			checkLetter++;
		}

		int checkDigit = 0;
		while (checkDigit < 10) {
			if (password.contains(checkDigit + ""))
				break;
			if (checkDigit == 9)
				return false;
			checkDigit++;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", password=" + getPassword() + ", email=" + getEmail() + ", CouponList="
				+ getCouponList();
	}

}
