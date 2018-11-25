package work2;

public class VideoStoreMain {

	public static void main(String[] args) {
		VideoStore v1 = new VideoStore("dealpool");
		System.out.println(v1.getTitle());
		System.out.println(v1.getAverageRating());
		v1.addRating(8.3);
		System.out.println(v1.getAverageRating());
		v1.addRating(9);
		VideoCatalogue c1 = new VideoCatalogue();
		c1.addVideo(new VideoStore(v1), "rampage"); /////// why i did -new VideoStore- i want this work on method
		c1.addVideo(new VideoStore(v1), "mullan");
		System.out.println(v1.isCheckedOut());
		v1.returnToStore();
		System.out.println(v1.isCheckedOut());
		c1.checkOutVideo(0);
		c1.returnVideo(0);
		c1.rateVideo(1, 9);
		System.out.println(v1.getAverageRating());
		c1.listCatalogue();
		System.out.println();
		System.out.println(c1.getVideoByTitle("mullan").getAverageRating());
	}

}
