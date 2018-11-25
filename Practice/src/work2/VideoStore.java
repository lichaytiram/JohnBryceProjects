package work2;

public class VideoStore {
	private String title;
	private boolean checkOut;
	private double ratingSum;
	private int ratingCount;
	private double averageRating;

	public VideoStore(String title) {
		this.title = title;
	}
	public VideoStore(VideoStore newvideo) {
		this.title=newvideo.title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public double getAverageRating() {
		if (ratingCount != 0) {
			averageRating = ratingSum / ratingCount;
			return averageRating;
		} else
			return 0;

	}

	public void addRating(double rate) {
		ratingSum += rate;
		ratingCount++;

	}

	public void checkOut() {
		this.checkOut = false;
	}

	public void returnToStore() {
		this.checkOut = true;
	}

	public boolean isCheckedOut() {
		return checkOut;
	}

}
