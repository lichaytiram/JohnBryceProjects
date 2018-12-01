package Program9;

public class Program {
	public static void main(String[] args) {
		Car car1 = new Car("sv123456", 1330);
		Car car2 = new Car(car1);
		car1.gaz();
		car1.gaz();
		System.out.println(car1);
		System.out.println(car2);
		System.out.println("----------------");
		car1.setLicenseNumber("rr2354");
		car2.setMileage(20);
		car1.slow();
		System.out.println(car1);
		System.out.println(car2);

		System.out.println("----------------");
	}
}
