package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create a company
 * 
 * @author Lichay
 *
 */
public class Company {

	// property

	private long id;
	private String name;
	private String phoneNumber;
	private String email;
	private List<Coupon> couponList;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id       Receive an id
	 * @param name     Receive a name for company
	 * @param password Receive a phone number
	 * @param email    Receive an email
	 */
	public Company(long id, String name, String phoneNumber, String email) {
		this(name, phoneNumber, email);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param name     Receive a name for company
	 * @param password Receive a phone number
	 * @param email    Receive an email
	 */
	public Company(String name, String phoneNumber, String email) {
		this();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;

	}

	/**
	 * constructor for create a show for this class
	 * 
	 */
	public Company() {
		super();
		couponList = new ArrayList<>();
	}

	// getter & setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}

	@Override
	public String toString() {
		return "Company [id=" + getId() + ", name=" + getName() + ", phoneNumber=" + getPhoneNumber() + ", email="
				+ getEmail() + "]";
	}

}