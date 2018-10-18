package Day17_10_2018;

public class DaleGround extends Dale {
	private String groundJob;

	public DaleGround(String firstName, String lastName, int experienceTime, String from, String groundJob) {
		super(firstName, lastName, experienceTime, from);
		this.groundJob = groundJob;
	}

	@Override
	public String toString() {
		return super.toString() + "DaleGround [groundJob=" + groundJob + "]\n";
	}

}
