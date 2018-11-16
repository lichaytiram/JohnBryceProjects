package Program27;

public abstract class Model {
	private String name;
	private int hight;
	private int weight;

	public Model(String name, int hight, int weight) {
		super();
		this.name = name;
		this.hight = hight;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHight() {
		return hight;
	}

	@Override
	public String toString() {
		return "Model [name=" + name + ", hight=" + hight + ", weight=" + weight + "]\n";
	}

}
