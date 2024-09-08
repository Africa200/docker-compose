package abdoul.net.accountservice.entities;

import abdoul.net.accountservice.enumeration.AccountType;
import abdoul.net.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
