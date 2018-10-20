package Program12;

import java.util.Arrays;

public class Hall {
	private Movie[] mArr = new Movie[6];

	public Hall(Movie[] mArr, Movie movie) {
		super();
		for (int i = 0; i < mArr.length; i++) {
			if (mArr[i] == null) {
				this.mArr[i] = movie;
				break;
			}
		}
	}

	public Movie[] getmArr() {
		return mArr;
	}

	@Override
	public String toString() {
		return "Hall [mArr=" + Arrays.toString(mArr) + "]";
	}

}
