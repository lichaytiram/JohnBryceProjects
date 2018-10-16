package Program2;

public class Hotel {

	private int numOfUsedRooms;
	private Room[][] allRooms;

	public Hotel(int numOfUsedRooms, int numOfBeds, int floor, int room) {
		if (numOfUsedRooms <= numOfBeds)
			this.numOfUsedRooms = numOfUsedRooms;
		else
			System.out.println("don't have enough beds");
		if (floor < 10 && room < 100)
			allRooms = new Room[floor][room];
		else
			System.out.println("no place in Hotel");
	}

	public void addRoom(Room room) {
		boolean ch = false;
		for (int i = 0; i < allRooms.length; i++) {
			for (int j = 0; j < allRooms[i].length; j++) {
				if (allRooms[i][j] == null) {
					allRooms[i][j] = room;
					ch = true;
					break;
				}
			}
			if (ch == true)
				break;
		}
	}

	public int getNumOfUsedRooms() {
		return numOfUsedRooms;
	}

	public Room getRoom(int floor, int room) {
		return allRooms[floor][room];
	}

	public String getPassport(int passport) {
		for (int i = 0; i < allRooms.length; i++) {
			for (int j = 0; j < allRooms[i].length; j++) {
				for (int j2 = 0; j2 < allRooms[i].length; j2++) {
					if (allRooms[i][j].getAllGuests(j2) != null)
						if (allRooms[i][j].getAllGuests(j2).getPassportNumber() == passport) // problem by console
							return "floor " + i + " room " + j;
				}
			}
		}
		return -1 + " ";
	}
}
