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

	// properties

	private long id;
	private String name;
	private String password;
	private String email;
	private List<Coupon> couponList;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id       Receive an id
	 * @param name     Receive a name for company
	 * @param email    Receive an email
	 * @param password Receive a password
	 */
	public Company(long id, String name, String email, String password) {
		this(name, email, password);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param name     Receive a name for company
	 * @param email    Receive an email
	 * @param password Receive a password
	 */
	public Company(String name, String email, String password) {
		this();
		this.name = name;
		this.email = email;
		this.password = password;

	}

	/**
	 * constructor for create a show for this class
	 * 
	 */
	public Company() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Company [id=" + getId() + ", name=" + getName() + ", password=" + getPassword() + ", email="
				+ getEmail() + "]";
	}

}