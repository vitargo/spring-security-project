package org.vitargo.springsecuritysection13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection13.model.Accounts;
import org.vitargo.springsecuritysection13.model.Customer;
import org.vitargo.springsecuritysection13.repository.AccountsRepository;
import org.vitargo.springsecuritysection13.repository.CustomerRepository;

import java.util.List;

@RestController
public class AccountController {

    private final AccountsRepository accountsRepository;

    private CustomerRepository customerRepository;

    public AccountController(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/account")
    public Accounts getAccountDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findCustomerByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            Accounts accounts = accountsRepository.findByCustomerId(customers.get(0).getCustomerId());
            if (accounts != null) {
                return accounts;
            }
        }
        return null;
    }
}
