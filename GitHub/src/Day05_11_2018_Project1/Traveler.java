package Day05_11_2018_Project1;

public class Traveler {

	private int price;
	private int moneyPerSuitcase;
	private Suitcase suitcase;
	private int moneyForExtraPlace;

	public Traveler(int price, int moneyPerSuitcase, Suitcase suitcase, int moneyForExtraPlace) {
		this.price = price;
		this.moneyPerSuitcase = moneyPerSuitcase;
		this.suitcase = suitcase;
		this.moneyForExtraPlace = moneyForExtraPlace;
	}

	public int getPrice() {
		return price;
	}

	public int getMoneyPerSuitcase() {
		return moneyPerSuitcase;
	}

	public Suitcase getSuitcase() {
		return suitcase;
	}

	public int getMoneyForExtraPlace() {
		return moneyForExtraPlace;
	}

	@Override
	public String toString() {
		return "Traveler [getPrice()=" + getPrice() + ", getMoneyPerSuitcase()=" + getMoneyPerSuitcase()
				+ ", getSuitcase()=" + getSuitcase() + ", getMoneyForExtraPlace()=" + getMoneyForExtraPlace() + "]";
	}

}
