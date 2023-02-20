package org.vitargo.springsecuritysection13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection13.model.Customer;
import org.vitargo.springsecuritysection13.repository.AccountTransactionsRepository;
import org.vitargo.springsecuritysection13.model.AccountTransactions;
import org.vitargo.springsecuritysection13.repository.CustomerRepository;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    private CustomerRepository customerRepository;

    public BalanceController(AccountTransactionsRepository accountTransactionsRepository, CustomerRepository customerRepository) {
        this.accountTransactionsRepository = accountTransactionsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/balance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findCustomerByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                    findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getCustomerId());
            if (accountTransactions != null ) {
                return accountTransactions;
            }
        }
        return null;
    }
}
