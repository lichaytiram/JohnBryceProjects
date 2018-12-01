package Program9;

public class Car {
	private int balance;
	private String licenseNumber;
	private int sizeEngine;
	private double Mileage;

	public Car(String licenseNumber, int sizeEngine) {
		balance = 0;
		this.licenseNumber = licenseNumber;
		this.sizeEngine = sizeEngine;
		Mileage = 0;
	}

	public Car(String licenseNumber, int sizeEngine, double Mileage) {
		balance = 0;
		this.licenseNumber = licenseNumber;
		this.sizeEngine = sizeEngine;
		this.Mileage = Mileage;
	}

	public Car(Car car) {
		balance = car.balance;
		licenseNumber = car.licenseNumber;
		sizeEngine = car.sizeEngine;
		Mileage = car.Mileage;
	}

	public void slow() {
		if (balance > 0) {
			balance--;
			Mileage += 0.1;
		} else
			System.out.println("The car don't move");
	}

	public void gaz() {
		if (balance < 220) {
			balance++;
			Mileage += 0.1;
		} else
			System.out.println("max speed");
	}

	public void stop() {
		while (balance > 0) {
			Mileage += 0.1;
			balance--;
		}
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getBalance() {
		return balance;
	}

	public int getSizeEngine() {
		return sizeEngine;
	}

	public void setMileage(int value) {
		Mileage = value;
	}

	public double getMileage() {
		return Mileage;
	}

	@Override
	public String toString() {
		return "Car [balance=" + balance + ", licenseNumber=" + licenseNumber + ", sizeEngine=" + sizeEngine
				+ ", Mileage=" + Mileage + "]";
	}

}
