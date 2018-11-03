package Program19;

import java.util.ArrayList;

public class MobliePhone {
	private ArrayList<Contact> Contactlist;

	public MobliePhone() {
		Contactlist = new ArrayList<Contact>();
	}

	public void addPhone(MobliePhone.Contact c) {
		if (Contactlist.equals(c))
			Contactlist.add(c);
	}

	public void deletePhone(MobliePhone.Contact c) {
		Contactlist.remove(c);
	}

	public void show() {

	}

	public class Contact {
		private String name;
		private int numberPhone;

		public Contact(String name, int numberPhone) {
			super();
			this.name = name;
			this.numberPhone = numberPhone;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumberPhone() {
			return numberPhone;
		}

		public void setNumberPhone(int numberPhone) {
			this.numberPhone = numberPhone;
		}

		@Override
		public String toString() {
			return "Contact [name=" + name + ", numberPhone=" + numberPhone + "]";
		}

	}
}
