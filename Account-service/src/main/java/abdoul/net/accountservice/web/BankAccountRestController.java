package abdoul.net.accountservice.web;

import abdoul.net.accountservice.clients.CustomerRestClient;
import abdoul.net.accountservice.entities.BankAccount;
import abdoul.net.accountservice.models.Customer;
import abdoul.net.accountservice.repositories.BankAccountrepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
    private BankAccountrepository accountrepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountrepository accountrepository, CustomerRestClient customerRestClient) {
        this.accountrepository = accountrepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> bankAccounts(){
        List<BankAccount> bankAccounts = accountrepository.findAll();
        bankAccounts.forEach(bankAccount -> bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId())));
        return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){

        BankAccount bankAccount = accountrepository.findById(id).orElseThrow();
        Customer  customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
