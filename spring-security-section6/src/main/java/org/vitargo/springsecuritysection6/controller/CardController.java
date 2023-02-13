package org.vitargo.springsecuritysection6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection6.model.Cards;
import org.vitargo.springsecuritysection6.repository.CardsRepository;

import java.util.List;

@RestController
public class CardController {

    private final CardsRepository cardsRepository;

    public CardController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping("/cards")
    public List<Cards> getCardDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
