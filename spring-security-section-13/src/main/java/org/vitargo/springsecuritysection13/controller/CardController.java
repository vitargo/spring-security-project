package org.vitargo.springsecuritysection13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection13.model.Customer;
import org.vitargo.springsecuritysection13.repository.CardsRepository;
import org.vitargo.springsecuritysection13.model.Cards;
import org.vitargo.springsecuritysection13.repository.CustomerRepository;

import java.util.List;

@RestController
public class CardController {

    private final CardsRepository cardsRepository;

    private CustomerRepository customerRepository;

    public CardController(CardsRepository cardsRepository, CustomerRepository customerRepository) {
        this.cardsRepository = cardsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/cards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findCustomerByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Cards> cards = cardsRepository.findByCustomerId(customers.get(0).getCustomerId());
            if (cards != null ) {
                return cards;
            }
        }
        return null;
    }
}
