package Program5;

public class Program5 {

	public static void main(String[] args) {

		Name name = new Name("Haiim", "Yosef", "Choen");
		Address address = new Address("Israel", "Jerusalem", "Ben Yehuda", 13);
		Person person = new Person(4321234, name, address);
		BankAccount bankAccount = new BankAccount(1234321, person);
		System.out.println(bankAccount.getStatus());
		Transaction deposit = new Transaction(5,"Deposit", 20000);
		bankAccount.execute(deposit);
		System.out.println(bankAccount.getStatus());
		bankAccount.execute(deposit);
		System.out.println(bankAccount.getStatus());
		Transaction withdrawal = new Transaction(4,"Withdrawal", 1000);
		bankAccount.execute(withdrawal);
		System.out.println(bankAccount.getStatus());
	}

}
