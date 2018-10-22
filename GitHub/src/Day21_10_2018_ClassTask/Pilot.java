package Day21_10_2018_ClassTask;

public class Pilot implements IFly {
	private String name;
	private String company;
	private String destination;

	public Pilot() {
		super();
		this.name = "roman";
		this.company = "engineerAir";
		this.destination = "usa";
	}

	@Override
	public String toString() {
		return "Pilot [name=" + name + ", company=" + company + ", destination=" + destination + "]";
	}

	@Override
	public void fly(int speed) {
		System.out.println("He fly speed of " + speed);
	}

	@Override
	public boolean land() {
		return true;
	}

}
