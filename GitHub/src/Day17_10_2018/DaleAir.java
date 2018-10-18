package Day17_10_2018;

public class DaleAir extends Dale {
	private String department;

	public DaleAir(String firstName, String lastName, int experienceTime, String from, String department) {
		super(firstName, lastName, experienceTime, from);
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + "DaleAir [department=" + department + "]\n";
	}

}
