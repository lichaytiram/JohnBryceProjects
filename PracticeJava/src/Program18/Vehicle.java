package Program18;

import java.util.Date;

public abstract class Vehicle {

	private int numberOfwheel;
	private int sizeEngine;
	private int numberOfLicense;
	private Date newTest;

	public Vehicle(int numberOfwheel, int sizeEngine, int numberOfLicense) {
		this.numberOfwheel = numberOfwheel;
		this.sizeEngine = sizeEngine;
		this.numberOfLicense = numberOfLicense;
	}

	public int getNumberOfwheel() {
		return numberOfwheel;
	}

	public void setNumberOfwheel(int numberOfwheel) {
		this.numberOfwheel = numberOfwheel;
	}

	public int getSizeEngine() {
		return sizeEngine;
	}

	public void setSizeEngine(int sizeEngine) {
		this.sizeEngine = sizeEngine;
	}

	public int getNumberOfLicense() {
		return numberOfLicense;
	}

	public void setNumberOfLicense(int numberOfLicense) {
		this.numberOfLicense = numberOfLicense;
	}

	public void newTest() {
		System.out.println("you did a test for your car");
		this.newTest = new Date();
	}

	@Override
	public String toString() {
		return "Vehicle [numberOfwheel=" + numberOfwheel + ", sizeEngine=" + sizeEngine + ", numberOfLicense="
				+ numberOfLicense + ", newTest=" + newTest + "]";
	}

}
