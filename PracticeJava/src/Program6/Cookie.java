package Program6;

public class Cookie {

	private boolean withGloten;
	private int numOfEggs;
	private int suggar;
	private int flour;

	public Cookie(boolean withGloten, int numOfEggs, int suggar, int flour) {
		super();
		this.withGloten = withGloten;
		this.numOfEggs = numOfEggs;
		this.suggar = suggar;
		this.flour = flour;
	}

	@Override
	public String toString() {
		return "Cookie [withGloten=" + withGloten + ", numOfEggs=" + numOfEggs + ", suggar=" + suggar + ", flour="
				+ flour + "]";
	}

	public boolean isWithGloten() {
		return withGloten;
	}

	public void setWithGloten(boolean withGloten) {
		this.withGloten = withGloten;
	}

	public int getNumOfEggs() {
		return numOfEggs;
	}

	public void setNumOfEggs(int numOfEggs) {
		this.numOfEggs = numOfEggs;
	}

	public int getSuggar() {
		return suggar;
	}

	public void setSuggar(int suggar) {
		this.suggar = suggar;
	}

	public int getFlour() {
		return flour;
	}

	public void setFlour(int flour) {
		this.flour = flour;
	}

}
