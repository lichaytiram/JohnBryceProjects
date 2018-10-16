package class3;

public class Date {
	int dd,mm,yy;
	
	public Date(int dd,int mm,int yy) {
		this.dd=dd;
		this.mm=mm;
		this.yy=yy;
		
	}
	public void nextDay() {
		if(dd<30)
			dd++;
		else if(mm<12) {
			dd=1;
			mm++;
		}else {
			dd=1;
			mm=1;
			yy++;
		}
		
		System.out.println("Next Day ["+dd + "/" + mm + "/" + yy + "]");
	}

	public String toString() {
		return "["+dd + "/" + mm + "/" + yy + "]";
	}
	
	
}
