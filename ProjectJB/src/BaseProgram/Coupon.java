package BaseProgram;

import java.util.Date;

import Exception.ExceptionName;

public class Coupon extends BaseAttribute {

	private int companyId;
	private Category category;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private int amount;
	private double price;
	private String image;

	public Coupon(int id, int companyId, Category category, String title, String description, Date startDate,
			Date endDate, int amount, double price, String image) throws ExceptionName {
		super(id);
//		this.companyId = companyId;
//		this.category = category;
//		this.title = title;
//		this.description = description;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.amount = amount;
//		this.price = price;
//		this.image = image;
	}

}
