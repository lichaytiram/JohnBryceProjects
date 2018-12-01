package Program19;

public class Program {
	public static void main(String[] args) {
		MobliePhone m = new MobliePhone();
		MobliePhone.Contact c1 = m.new Contact("moshe", 222222222);
		MobliePhone.Contact c2 = m.new Contact("doron", 888444444);
		m.addPhone(c1);
		System.out.println(m);
		m.addPhone(c2);
		m.show("doron");
		System.out.println(m);
		m.deletePhone(c1);
		System.out.println(m);
		m.addPhone(c1);
		System.out.println(m);
		m.deletePhoneByName("moshe");
		System.out.println(m);
		m.addPhone(c1);
		System.out.println(m);
		m.updateContact(m, "moshe", 222222222, "wowP", 456789);
		System.out.println(m);
	}
}
