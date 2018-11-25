package work4;

public class Driver extends Person {

	private String type;
	private int numOfLicence;
	private String typeOfLicence;

	public Driver(String name, int age, String id, String type, int numOfLicence, String typeOfLicence) {
		super(name, age, id);
		this.type = type;
		this.numOfLicence = numOfLicence;
		this.typeOfLicence = typeOfLicence;
	}

	public String getType() {
		return type;
	}

	public int getNumOfLicence() {
		return numOfLicence;
	}

	public String getTypeOfLicence() {
		return typeOfLicence;
	}

	public String Print() {
		return super.Print() + "\nDriver [Type - " + getType() + " ,numOfLicence - " + getNumOfLicence()
				+ " ,typeOfLicence - " + getTypeOfLicence() + "]";
	}

}
