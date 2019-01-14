package BaseProgram;

import java.util.ArrayList;
import Exception.ExceptionName;

public abstract class SecondBaseAttribute extends BaseAttribute {

	// properties

	private String password;
	private String email;
	private ArrayList<Coupon> couponList;

	// constructor

	public SecondBaseAttribute(int id, String password, String email) throws ExceptionName {
		super(id);
		setPassword(password);
		setEmail(email);
		couponList = new ArrayList<>();
	}

	public SecondBaseAttribute(String password, String email) throws ExceptionName {
		super();
		setPassword(password);
		setEmail(email);
		couponList = new ArrayList<>();
	}

	// getter & setter

	// fix show list
	public ArrayList<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(Coupon coupon) throws ExceptionName {
		for (int i = 0; i < couponList.size(); i++)
			if (couponList.get(i).getId() == coupon.getId() && couponList.get(i).getCompanyId() == coupon.getCompanyId()
					&& couponList.get(i).getCategory().equals(coupon.getCategory()))
				throw new ExceptionName("The coupon already exists");
		couponList.add(coupon);
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
		return super.toString() + ", password=" + getPassword() + ", email=" + getEmail() + ", couponList="
				+ getCouponList();
	}

}
