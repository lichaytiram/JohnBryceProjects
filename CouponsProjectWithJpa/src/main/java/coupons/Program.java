package coupons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import coupons.exception.ApplicationException;

@SpringBootApplication
@EnableTransactionManagement
public class Program {
	public static void main(String[] args) throws ApplicationException {

		SpringApplication.run(Program.class, args);

	}
}