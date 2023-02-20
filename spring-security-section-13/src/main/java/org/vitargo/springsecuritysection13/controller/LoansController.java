package org.vitargo.springsecuritysection13.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection13.model.Customer;
import org.vitargo.springsecuritysection13.repository.CustomerRepository;
import org.vitargo.springsecuritysection13.repository.LoanRepository;
import org.vitargo.springsecuritysection13.model.Loans;

import java.util.List;

@RestController
public class LoansController {

    private final LoanRepository loanRepository;

    private CustomerRepository customerRepository;

    public LoansController(LoanRepository loanRepository, CustomerRepository customerRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/loans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findCustomerByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customers.get(0).getCustomerId());
            if (loans != null ) {
                return loans;
            }
        }
        return null;
    }
}
