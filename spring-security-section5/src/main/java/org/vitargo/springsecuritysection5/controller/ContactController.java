package org.vitargo.springsecuritysection5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping ("/contact")
    public String getContact() {
        return "Contact!";
    }
}
