package org.vitargo.springsecuritysection3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/cards")
    public String getCards(){
        return "Your cards!";
    }
}
