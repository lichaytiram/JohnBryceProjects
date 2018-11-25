package work2;

public class VideoCatalogue {
	private VideoStore[] catalogue = new VideoStore[10];
	private int VideoCount;

	public void addVideo(VideoStore video, String title) {
		this.catalogue[VideoCount] = video;
		this.catalogue[VideoCount].setTitle(title);
		VideoCount++;
	}

	public void checkOutVideo(int value) {
		System.out.println(catalogue[value].isCheckedOut());
	}

	public void returnVideo(int index) {
		System.out.println(catalogue[index].getTitle());
	}

	public void rateVideo(int index, int rating) {
		this.catalogue[index].addRating(rating);
	}

	public VideoStore getVideoByTitle(String title) {
		for (int i = 0; i < catalogue.length; i++) {
			if (catalogue[i].getTitle() == title)
				return catalogue[i];

		}
		return null;
	}

	public void listCatalogue() {
		for (int i = 0; i < catalogue.length; i++) {
			if (catalogue[i] != null) {
				System.out.print("\n" + catalogue[i].getTitle() + "\n" + catalogue[i].getAverageRating() + "\n"
						+ catalogue[i].isCheckedOut() + "\n");
			}
		}

	}
}
