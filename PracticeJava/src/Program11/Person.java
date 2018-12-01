package Program11;

public class Person {

	private String name;
	private String dad;
	private String mom;
	private Date date;

	public Person(String name, String dad, String mom, Date date) {
		super();
		this.name = name;
		this.dad = dad != "" ? dad : "null";
		this.mom = mom != "" ? mom : "null";
		this.date = date;
	}

	@Override
	public String toString() {
		return date + "\nPerson [name=" + name + ", dad=" + dad + ", mom=" + mom + "]";
	}

}
