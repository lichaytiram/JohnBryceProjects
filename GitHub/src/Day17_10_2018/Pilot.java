package Day17_10_2018;

public class Pilot extends experiencePerson {

	private int numberOfLicense;

	public Pilot(String firstName, String lastName, int experienceTime, int numberOfLicense) {
		super(firstName, lastName, experienceTime);
		this.numberOfLicense = numberOfLicense;
	}

	@Override
	public String toString() {
		return "Pilot [numberOfLicense=" + numberOfLicense + "]\n";
	}

}
