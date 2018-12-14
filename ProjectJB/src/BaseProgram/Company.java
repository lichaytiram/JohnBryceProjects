package BaseProgram;

import Exception.ExceptionName;

public class Company extends SecondBaseAttribute {
	private String name;

	// constructor

	public Company(int id, String password, String email, String name) throws ExceptionName {
		super(id, password, email);
		setName(name);

	}

	// getter & setter

	public String getName() {
		return name;
	}

	public void setName(String name) throws ExceptionName {
		if (name.length() < 2)
			throw new ExceptionName("Your company name is invalid (must contain at least 2 letters)");
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + ", name=" + getName() + "]";
	}

}