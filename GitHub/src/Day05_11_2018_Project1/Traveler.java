package Day05_11_2018_Project1;

public class Traveler {

	private int price;
	private int kgAllowedPerSuitcase;
	private Suitcase suitcase;
	private int moneyForExtraPlace;

	public Traveler(int price, int kgAllowedPerSuitcase, Suitcase suitcase, int moneyForExtraPlace) {
		this.price = price;
		this.kgAllowedPerSuitcase = kgAllowedPerSuitcase;
		this.suitcase = suitcase;
		this.moneyForExtraPlace = moneyForExtraPlace;
	}

	public int getPrice() {
		return price;
	}

	public int getKgAllowedPerSuitcase() {
		return kgAllowedPerSuitcase;
	}

	public Suitcase getSuitcase() {
		return suitcase;
	}

	public int getMoneyForExtraPlace() {
		return moneyForExtraPlace;
	}

	@Override
	public String toString() {
		return "Traveler [Price=" + getPrice() + ", kgAllowedPerSuitcase=" + getKgAllowedPerSuitcase()
				+ ", Suitcase=" + getSuitcase() + ", MoneyForExtraPlace=" + getMoneyForExtraPlace() + "]";
	}

}
