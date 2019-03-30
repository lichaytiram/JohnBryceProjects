package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create a customer
 * 
 * @author Lichay
 *
 */
public class Customer {

	// properties

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<Coupon> couponList;
	private User user;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id        Receive an id
	 * @param firstName Receive a first name
	 * @param lastName  Receive a last name
	 * @param email     Receive an email
	 * @param password  Receive a password
	 */
	public Customer(long id, String firstName, String lastName, String email) {
		this(firstName, lastName, email);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param firstName Receive a first name
	 * @param lastName  Receive a last name
	 * @param email     Receive an email
	 * @param password  Receive a password
	 */
	public Customer(String firstName, String lastName, String email) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * 
	 * constructor for create a show for this class
	 */
	public Customer() {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [ id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", email="
				+ getEmail() + " ]";
	}

}
