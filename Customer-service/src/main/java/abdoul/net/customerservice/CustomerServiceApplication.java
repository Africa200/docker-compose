package abdoul.net.customerservice;

import abdoul.net.customerservice.config.GlobalConfig;
import abdoul.net.customerservice.entities.Customer;
import abdoul.net.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			Customer customer=Customer.builder()
					.firstName("abdoul")
					.lastName("kamal")
					.email("kamal@kamal")
					.build();
			customerRepository.save(customer);
			Customer customer1=Customer.builder()
					.firstName("rachid")
					.lastName("ras")
					.email("rachid@rachid")
					.build();
			customerRepository.save(customer1);
		};
	}
}
