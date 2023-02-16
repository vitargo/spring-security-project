package org.vitargo.springsecuritysection10.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.vitargo.springsecuritysection10.model.Authority;
import org.vitargo.springsecuritysection10.model.Customer;
import org.vitargo.springsecuritysection10.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class CustomUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    public CustomUsernamePasswordAuthenticationProvider(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findCustomerByEmail(userName);
        log.info("Customer id {} and authorities: {}", customer.get(0).getCustomerId(), Arrays.toString(customer.get(0).getAuthorities().toArray(new Authority[0])) );
        if (!customer.isEmpty()) {
            if (passwordEncoder.matches(password, customer.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(userName, password, getGrantedAuthorities(customer.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        } else {
            throw new BadCredentialsException("Customer not found!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
