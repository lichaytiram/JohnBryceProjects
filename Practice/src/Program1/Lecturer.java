package Program1;

public class Lecturer {
	private String name;
	private int numOfTimesPenFalls;
	private String favoriteIceCreem;

	public Lecturer(String name, int numOfTimesPenFalls, String favoriteIceCreem) {
		this.name = name;
		this.numOfTimesPenFalls = numOfTimesPenFalls;
		this.favoriteIceCreem = favoriteIceCreem;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumOfTimesPenFalls(int numOfTimesPenFalls) {
		this.numOfTimesPenFalls = numOfTimesPenFalls;
	}

	public int getNumOfTimesPenFalls() {
		return numOfTimesPenFalls;
	}

	public void setFavoriteIceCreem(String favoriteIceCreem) {
		this.favoriteIceCreem = favoriteIceCreem;
	}

	public String getFavoriteIceCreem() {
		return favoriteIceCreem;
	}

	public String toString() {
		return "Lecturer [name " + name + " ,numOfTimesPenFalls " + numOfTimesPenFalls + " ,favoriteIceCreem "
				+ favoriteIceCreem + "]";
	}

}
