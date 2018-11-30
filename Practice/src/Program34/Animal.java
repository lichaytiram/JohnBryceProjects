package Program34;

public abstract class Animal implements Comparable<Animal> {
	private String name;
	private int age;
	private int sumAnimal;
	public static int allAnimals = 1;

	public Animal(String name, int age) {
		setName(name);
		setAge(age);
		this.sumAnimal = allAnimals;
		allAnimals++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age > 0 ? age : 0;
	}

	@Override
	public int compareTo(Animal a) {
		return this.name.compareTo(a.name);
	}

	@Override
	public String toString() {
		return "Animal - " + sumAnimal + " [Name()=" + getName() + ", Age()=" + getAge() + "]\n";
	}

}
