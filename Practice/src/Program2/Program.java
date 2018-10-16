package Program2;

public class Program {

	public static void main(String[] args) {
		Guest g1 = new Guest("dan", 2);
		Guest g2 = new Guest("moshe", 8);
		Guest g3 = new Guest("din", 3);
		Room r1 = new Room(2);
		Room r2 = new Room(2);
		Room r3 = new Room(1);
		r1.addGuest(g1);
		r2.addGuest(g2);
		r2.addGuest(g3);
		r3.addGuest(g2);
		System.out.println(r1.getAllGuests(1));
		Hotel h = new Hotel(2, 2, 2, 2);
		h.addRoom(r1);
		System.out.println();
		h.addRoom(r2);
		h.addRoom(r3);
		h.addRoom(r3);
		h.addRoom(r3);
		h.addRoom(r3);
		System.out.println(r1.getAllGuests(0).getName());
		System.out.println(r2.getAllGuests(1).getName());
		System.out.println(h.getRoom(0, 0).getAllGuests(0).getName());
		System.out.println(h.getPassport(2));
	}

}
