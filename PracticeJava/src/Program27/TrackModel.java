package Program27;

public class TrackModel extends Model {

	public TrackModel(String name, int hight, int weight) {

		super(name, hight, weight);

	}

	@Override
	public String toString() {
		return "TrackModel - " + super.toString();
	}

}
