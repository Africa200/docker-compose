package abdoul.net.accountservice;

import abdoul.net.accountservice.entities.BankAccount;
import abdoul.net.accountservice.enumeration.AccountType;
import abdoul.net.accountservice.repositories.BankAccountrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountrepository bankAccountrepository) {
		return args -> {
			bankAccountrepository.saveAll(
					List.of(
							BankAccount.builder()
									.balance(10000)
									.createAt(LocalDate.now())
									.currency("USD")
									.type(AccountType.CURRENT_ACCOUNT)
									.customerId(1L)
									.build(),

							BankAccount.builder()
									.balance(200000)
									.createAt(LocalDate.now())
									.currency("EUR")
									.type(AccountType.SAVINGS_ACCOUNT)
									.customerId(1L)
									.build(),

							BankAccount.builder()
									.balance(250000)
									.createAt(LocalDate.now())
									.currency("FCFA")
									.type(AccountType.CURRENT_ACCOUNT)
									.customerId(1L)
									.build()
					)
			);
		};
	}
}
