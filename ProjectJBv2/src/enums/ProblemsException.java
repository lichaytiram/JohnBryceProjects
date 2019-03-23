package enums;

public enum ProblemsException {
	problem("Have a problem:\n"),
	COUPON_DATE("This date isn't well!"),
	COUPON_ID("This coupon id isn't exist");
	
	
	
	private String name;

	private ProblemsException(String problem) {
		this.name = problem;
	}

	public String getName() {
		return name;
	}

}
