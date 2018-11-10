package Program24;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Person p1 = new Person("moshe");
		Person p2 = new Person("doron");
		BankAccount b1 = new BankAccount(p1);
		BankAccount b2 = new BankAccount(p2);
		Bank bank = new Bank();
		bank.addCustomer(b1);
		bank.addCustomer(b2);
		Queue<BankAccount> q = new LinkedList<>();
		q.add(b1);
		q.add(b2);
		System.out.println(bank);

		while (q.size() != 0) {
			System.out.println("What do you need to do in our Bank?");
			String action = scan.next();
			if(action.equals("deposite"))
				q.poll().deposite(55.3);
			if(action.equals("withdraw"))
				q.poll().withdraw(100);
			if(action.equals("info"))
				System.out.println(q.poll());
				
		}
		System.out.println(bank);
		scan.close();
	}
}
