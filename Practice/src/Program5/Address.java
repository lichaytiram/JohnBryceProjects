package Program5;

public class Address {

	private String country; // country
	private String city; // city
	private String street; // street name
	private int nu; // street number

	// trivial constructor
	public Address(String country, String city, String street, int nu) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.nu = nu;
	}

	// copy constructor
	public Address(Address address) {
		this.country = address.country;
		this.city = address.country;
		this.street = address.street;
		this.nu = address.nu;
	}

	// country getter
	public String getCountry() {
		return country;
	}

	// country setter
	public void setCountry(String country) {
		this.country = country;
	}

	// city getter
	public String getCity() {
		return city;
	}

	// city setter
	public void setCity(String city) {
		this.city = city;
	}

	// street getter
	public String getStreet() {
		return street;
	}

	// street setter
	public void setStreet(String street) {
		this.street = street;
	}

	// house number getter
	public int getNu() {
		return nu;
	}

	// house number setter
	public void setNu(int nu) {
		this.nu = nu;
	}

	public String toString() {
		return "Address [country " + country + " ,city " + city + " ,street " + street + " ,number " + nu + "]\n";
	}

	public boolean equals(Object x) {
		if (x instanceof Address)
			return true;
		return false;
	}
}