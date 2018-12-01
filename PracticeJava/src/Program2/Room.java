package Program2;

public class Room {
	private int numOfBeds;
	private Guest[] allGuests;

	public Room(int numOfbeds) {
		if (numOfbeds <= 4 && numOfbeds > 0)
			this.numOfBeds = numOfbeds;
		allGuests = new Guest[numOfBeds];
	}

	public void addGuest(Guest g) {
		for (int i = 0; i < allGuests.length; i++) {
			if (allGuests[i] == null) {
				allGuests[i] = g;
				break;
			}

		}
	}

	public int getNumOfBeds() {
		return numOfBeds;
	}

	public Guest getAllGuests(int i) {
		return allGuests[i];
	}

	public void setAllGuests(Guest[] allGuests) {
		this.allGuests = allGuests;
	}

	public String toString() {
		return "Room [numOfBeds=" + numOfBeds + "]";
	}

}
