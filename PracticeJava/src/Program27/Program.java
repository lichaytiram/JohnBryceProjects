package Program27;

public class Program {
	public static void main(String[] args) {

		ModelAgency m = new ModelAgency("TheBest");
		PhotoModel p1 = new PhotoModel("elise", 150, 54);
		DodelCompany d1 = new DodelCompany("oop", "10/10/1993", 20010);
		DodelCompany d2 = new DodelCompany("projectC", "12/02/1998", 25030);
		TrackModel t1 = new TrackModel("lin", 157, 54);
		TrackModel t2 = new TrackModel("lilian", 172, 54);
		p1.addListDodelCompany(d1);
		p1.addListDodelCompany(d2);
		m.addModel(p1);
		m.addModel(t1);
		m.addModel(t2);
		System.out.println(m.getModelInside("elise"));
		System.out.println(m.getModelInside("lin"));
		System.out.println(m.getModelInside("lilian"));
		System.out.println(m.getModelInside("elise").getHight());
		System.out.println(m);
	}
}
