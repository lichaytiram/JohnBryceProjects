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
	 * 
	 * constructor for create a show for this class
	 */
	public Customer() {
		super();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ ", phoneNumber=" + getPhoneNumber() + ", email=" + getEmail() + "]";
	}

}
