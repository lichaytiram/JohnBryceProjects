package Program27;

import java.util.ArrayList;

public class PhotoModel extends Model {

	ArrayList<DodelCompany> listDodelCompany;

	public PhotoModel(String name, int hight, int weight) {
		super(name, hight, weight);
		this.listDodelCompany = new ArrayList<>();
	}

	public ArrayList<DodelCompany> getListDodelCompany() {
		return listDodelCompany;
	}

	public void addListDodelCompany(DodelCompany company) {
		listDodelCompany.add(company);
	}

	@Override
	public String toString() {
		return "PhotoModel [listDodelCompany=" + getListDodelCompany() + "]\n" + super.toString();
	}

}
