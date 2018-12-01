package Program19;

import java.util.ArrayList;

public class MobliePhone {
	private ArrayList<Contact> Contactlist;

	public MobliePhone() {
		Contactlist = new ArrayList<Contact>();
	}

	public void addPhone(MobliePhone.Contact c) {
		boolean haveInside = true;
		for (int i = 0; i < Contactlist.size(); i++) {
			if (Contactlist.get(i).getName() == c.getName())
				haveInside = false;
		}
		if (haveInside)
			Contactlist.add(c);
	}

	public void updateContact(MobliePhone mobliePhone, String name, int number, String changeToNewName,
			int changeToNewNumber) {
		int nameI = 0, numberI = 0;
		for (int i = 0; i < Contactlist.size(); i++) {
			if (Contactlist.get(i).getName() == name)
				nameI = i;
			if (Contactlist.get(i).getNumberPhone() == number)
				numberI = i;
		}
		Contactlist.get(nameI).setName(changeToNewName);
		Contactlist.get(numberI).setNumberPhone(changeToNewNumber);
	}

	public void deletePhone(MobliePhone.Contact c) {
		Contactlist.remove(c);
	}

	public void deletePhoneByName(String name) {
		for (int i = 0; i < Contactlist.size(); i++) {
			if (Contactlist.get(i).getName() == name)
				Contactlist.remove(i);
		}
	}

	public void show(String name) {
		for (int i = 0; i < Contactlist.size(); i++) {
			if (Contactlist.get(i).getName() == name)
				System.out.println(Contactlist.get(i).toString());
		}
	}

	@Override
	public String toString() {
		return "MobliePhone [Contactlist=" + Contactlist + "]";
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
