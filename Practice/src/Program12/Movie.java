package Program12;

public class Movie {
	private String name;
	private int timeMovie;

	public Movie(String name, int timeMovie) {
		super();
		this.name = name;
		this.timeMovie = timeMovie;
	}

	public String getName() {
		return name;
	}

	public int getTimeMovie() {
		return timeMovie;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", timeMovie=" + timeMovie + "]";
	}


}
