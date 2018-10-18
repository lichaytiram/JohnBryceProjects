package Day17_10_2018;

public abstract class experiencePerson extends Person {

	private int experienceTime;

	public experiencePerson(String firstName, String lastName, int experienceTime) {
		super(firstName, lastName);
		this.experienceTime = experienceTime;
	}

	@Override
	public String toString() {
		return super.toString() + "experiencePerson [experienceTime=" + experienceTime + "]\n";
	}

}
