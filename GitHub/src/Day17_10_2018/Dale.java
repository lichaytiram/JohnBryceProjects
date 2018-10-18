package Day17_10_2018;

public abstract class Dale extends experiencePerson {
	private String from;

	public Dale(String firstName, String lastName, int experienceTime, String from) {
		super(firstName, lastName, experienceTime);
		this.from = from;
	}

	@Override
	public String toString() {
		return super.toString() + "Dale [from=" + from + "]\n";
	}

}
