package Program4;

public class Program4 {

	public static void main(String[] args) {
		Car c1 = new Car(150, "blue", "toyota");
		Car c2 = new Car(850, "yellow", "lamburgini");
		People p = new People("lichay",25,c1);
		System.out.println(p.getAge());
		System.out.println(p.getCar().getPrice());
		p.setAge(26);
		System.out.println(p.getAge());
		System.out.println(p.getCar().getColor());
		p.setCar(c2);
		System.out.println(p.getName());
		System.out.println(p.getCar().getPrice());
		
	}
}
