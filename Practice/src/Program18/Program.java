package Program18;

public class Program {
	public static void main(String[] args) {

		Car c1 = new Car(1330, 123456789, "blue");
		System.out.println(c1);
		c1.newTest();
		System.out.println(c1);
		Garage garage = new Garage();
		Motorcycle motorcycle1 = new Motorcycle(1330, 12345, 120);
		Motorcycle motorcycle2 = new Motorcycle(motorcycle1);
		garage.setVehicleInGarage(c1);
		garage.setVehicleInGarage(motorcycle1);
		garage.setVehicleInGarage(motorcycle2);
		System.out.println(garage.getVehicleFromGarage(0));
		System.out.print("");
		System.out.println(garage.garageTest(123456789));
		System.out.println(garage.getVehicleFromGarage(0));
		((Motorcycle) garage.getVehicleFromGarage(2)).setMaxSpeed(145);
		System.out.println("Print all Motorcycle from garage");
		garage.printMotorcycle();
		System.out.println("Print all Car from garage");
		garage.printCar();
	}
}
