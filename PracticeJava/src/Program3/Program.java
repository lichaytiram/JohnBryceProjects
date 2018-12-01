package Program3;

public class Program {

	public static void main(String[] args) {
		Mammal d = new Dog("jim", "black", 5, 2, true);
		Cat c = new Cat("jim", "black", 5, 2, "yes");
		System.out.println(c.getAge());
		System.out.println(((Dog) d).getIsNatural());
		System.out.println(d.getMilkproduction());
		System.out.println(d.getName());
		
	}
}
