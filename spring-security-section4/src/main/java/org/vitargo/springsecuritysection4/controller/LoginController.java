package org.vitargo.springsecuritysection4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection4.model.Customer;
import org.vitargo.springsecuritysection4.repository.CustomerRepository;

@RestController
public class LoginController {

    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    public LoginController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
         Customer savedCustomer = null;
         ResponseEntity response = null;
         try {
             String hashPassword = passwordEncoder.encode(customer.getPassword());
             customer.setPassword(hashPassword);
             savedCustomer = customerRepository.save(customer);
             if(savedCustomer.getId()>0){
                 response = ResponseEntity
                         .status(HttpStatus.CREATED)
                         .body("Given user details are successfully registered!");
             }
         } catch (Exception e){
             response = ResponseEntity
                     .status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("An exception occures due to " + e.getMessage());
         }
         return response;
    }
}
