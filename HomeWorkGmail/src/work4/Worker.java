package work4;

public class Worker extends Person {

	private String workspace;
	private int experience;

	public Worker(String name, int age, String id, String workspace, int experience) {
		super(name, age, id);
		this.workspace = workspace;
		this.experience = experience;
	}

	public String getWorkspace() {
		return workspace;
	}

	public int getExperience() {
		return experience;
	}

	public String Print() {
		return super.Print() + "\nWorker [Workspace - " + getWorkspace() + " ,Experience - " + getExperience() + "]";
	}
}
