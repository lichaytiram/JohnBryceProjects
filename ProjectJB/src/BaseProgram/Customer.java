package BaseProgram;

import Exception.ExceptionName;

public class Customer extends SecondBaseAttribute {

	private String firstName;
	private String lastName;

	public Customer(int id, String password, String email, String firstName, String lastName) throws ExceptionName {
		super(id, password, email);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	// name will be first big latter and after small latter

	public void setFirstName(String firstName) throws ExceptionName {
		if (firstName.length() < 2)
			throw new ExceptionName("Your first name must contain at least two letters");
		this.firstName = firstName.charAt(0) <= 'Z'
				? firstName.charAt(0) + firstName.substring(1, firstName.length()).toLowerCase()
				: (char) (firstName.charAt(0) - 32) + firstName.substring(1, firstName.length()).toLowerCase();
	}

	public String getLastName() {
		return lastName;
	}

	// name will be first big latter and after small latter

	public void setLastName(String lastName) throws ExceptionName {
		if (lastName.length() < 2)
			throw new ExceptionName("Your last name must contain at least two letters");
		this.lastName = lastName.charAt(0) <= 'Z'
				? lastName.charAt(0) + lastName.substring(1, lastName.length()).toLowerCase()
				: (char) (lastName.charAt(0) - 32) + lastName.substring(1, lastName.length()).toLowerCase();
	}

	@Override
	public String toString() {
		return "Customer->" + super.toString() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + "]";
	}

}
