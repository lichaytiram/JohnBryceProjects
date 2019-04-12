package beans;

/**
 * This class create a customer
 * 
 * @author Lichay
 *
 */
public class Customer {

	// property

	private long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private User user;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id          Receive an id
	 * @param firstName   Receive a first name
	 * @param lastName    Receive a last name
	 * @param phoneNumber Receive a phone number
	 * @param email       Receive an email
	 */

	public Customer(long id, String firstName, String lastName, String phoneNumber, String email) {
		this(firstName, lastName, phoneNumber, email);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param firstName   Receive a first name
	 * @param lastName    Receive a last name
	 * @param phoneNumber Receive a phone number
	 * @param email       Receive an email
	 */
	public Customer(String firstName, String lastName, String phoneNumber, String email) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * constructor for create a show for this class
	 */
	public Customer() {
		super();
		
	}

	// getter & setter

	/**
	 * @return This function return an id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id Receive an id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return This function return a first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName Receive a first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return This function get a last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName Receive a last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return This function return a phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber Receive a phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return This function return an email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email Receive an email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return This function return an user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user Receive an user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ ", phoneNumber=" + getPhoneNumber() + ", email=" + getEmail() + "]";
	}

}
