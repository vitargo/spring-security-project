package org.vitargo.springsecuritysection2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/loans")
    public String getLoans(){
        return "Your loans!";
    }
}
