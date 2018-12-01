package Program16;

public class GameOneToNine {

	private final int randomNum;
	private boolean isWin;

	public GameOneToNine() {
		super();
		this.randomNum = (int) (Math.random() * 10);
	}

	public boolean getIswin() {
		return isWin;
	}

	public boolean yourTurn(int number) {

		if (randomNum == number)
			isWin = true;

		return isWin;
	}

	@Override
	public String toString() {
		if (isWin)
			return "Good job you won and finish the game!!";
		return "Oh nice try.. maybe next time";
	}

}
