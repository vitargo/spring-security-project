package org.vitargo.springsecuritysection6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection6.model.Authority;
import org.vitargo.springsecuritysection6.repository.AuthorityRepository;

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
