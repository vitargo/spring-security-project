package org.vitargo.springsecuritysection13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection13.repository.AuthorityRepository;
import org.vitargo.springsecuritysection13.model.Authority;

import java.util.Set;

@RestController
public class AuthorityController {

    AuthorityRepository authorityRepository;

    public AuthorityController(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @GetMapping("/auth")
    public Set<Authority> getAuthorities(@RequestParam int id){
        return authorityRepository.getAuthoritiesByCustomerId(id);
    }
}
