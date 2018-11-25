package bankaccount;

public class Program {
	public static void main(String[]args) {
		Bank ac1= new Bank(30,5,"dani");
		System.out.println(ac1);
		ac1.withdraw(50);
		System.out.println(ac1);
		ac1.deposite(1000);
		System.out.println(ac1);
		
	}

}
