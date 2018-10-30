package Program18;

public abstract class vehicle {

	private int numberOfwheel;
	private int sizeEngine;
	private int numberOfLicense;
	private String lastTest;

	public vehicle(int numberOfwheel, int sizeEngine, int numberOfLicense) {
		this.numberOfwheel = numberOfwheel;
		this.sizeEngine = sizeEngine;
		this.numberOfLicense = numberOfLicense;
		this.lastTest = null;
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

	public void lastTest(String test) {
		System.out.println("you did a test for your car");
		this.lastTest = test;
	}

	@Override
	public String toString() {
		return "vehicle [numberOfwheel=" + numberOfwheel + ", sizeEngine=" + sizeEngine + ", numberOfLicense="
				+ numberOfLicense + ", lastTest=" + lastTest + "]";
	}

}
