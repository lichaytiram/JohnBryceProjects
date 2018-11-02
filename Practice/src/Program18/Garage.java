package Program18;

public class Garage {
	private Vehicle[] GarageOfVehicle;

	public Garage() {
		this.GarageOfVehicle = new Vehicle[15];
	}

	public void setVehicleInGarage(Vehicle vehicle) {
		for (int i = 0; i < GarageOfVehicle.length; i++) {
			if (GarageOfVehicle[i] == null) {
				GarageOfVehicle[i] = vehicle;
				System.out.println("Your car inside garage");
				break;
			}
		}
	}

	public Vehicle getVehicleFromGarage(int index) {
		return GarageOfVehicle[index];
	}

	public boolean garageTest(int getnumberoflicense) {
		for (int i = 0; i < GarageOfVehicle.length; i++) {
			if (GarageOfVehicle[i] == null)
				break;
			if (GarageOfVehicle[i].getNumberOfLicense() == getnumberoflicense) {
				GarageOfVehicle[i].newTest();
				return true;
			}
		}
		return false;
	}

	public void printMotorcycle() {
		for (int i = 0; i < GarageOfVehicle.length; i++) {
			if (GarageOfVehicle[i] instanceof Motorcycle)
				System.out.println(GarageOfVehicle[i].toString());
		}
	}
	
	public void printCar() {
		for (int i = 0; i < GarageOfVehicle.length; i++) {
			if (GarageOfVehicle[i] instanceof Car)
				System.out.println(GarageOfVehicle[i].toString());
		}
	}

}
