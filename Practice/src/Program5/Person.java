package Program5;

public class Person {

	private int id; // identification number
	private Name name; // name
	private Address address; // address

	// trivial constructor
	// use deep copy for name and address
	public Person(int id, Name name, Address address) {
		this.id = id;
		this.name = new Name(name);
		this.address = new Address(address);
	}

	// copy constructor
	public Person(Person person) {
		this.id = person.id;
		this.name = person.name;
		this.address = person.address;
	}

	// id number getter
	public int getId() {
		return id;
	}

	// name getter
	// use deep copy
	public Name getName() {
		return new Name(name);
	}

	// address getter
	// use deep copy
	public Address getAddress() {
		return new Address(address);
	}

	// name changer
	// use deep copy
	public void changeName(Name name) {
		this.name = new Name(name);
	}

	// address changer
// use deep copy
	public void changeAddress(Address address) {
		this.address = new Address(address);
	}

	public String toString() {
		return "Person [id " + id + " ,name " + name + " ,address " + address + "]\n";
	}

	public boolean equals(Object x) {
		if (x instanceof Person)
			return true;
		return false;
	}
}
