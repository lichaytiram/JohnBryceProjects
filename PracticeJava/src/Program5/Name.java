package Program5;

public class Name {

	private String firstName; // first name
	private String middleName; // middle name
	private String lastName; // last name

	// trivial constructor
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	// copy constructor
	public Name(Name name) {
		this.firstName = name.firstName;
		this.middleName = name.middleName;
		this.lastName = name.lastName;
	}

	// first name getter
	public String getFirstName() {
		return firstName;
	}

	// first name setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// middle name getter
	public String getMiddleName() {
		return middleName;
	}

	// middle name setter
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	// last name setter
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return "Name [firstName " + firstName + " ,middleName " + middleName + " ,lastName " + lastName + "]\n";
	}

	public boolean equals(Object x) {
		if (x instanceof Name)
			return true;
		return false;
	}
}
