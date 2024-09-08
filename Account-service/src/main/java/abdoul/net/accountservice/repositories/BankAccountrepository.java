package abdoul.net.accountservice.repositories;

import abdoul.net.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountrepository extends JpaRepository<BankAccount, String> {
}
