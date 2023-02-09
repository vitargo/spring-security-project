package org.vitargo.springsecuritysection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/account","/balance", "/loans","/cards").authenticated()
                .requestMatchers("/contact", "/notices").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }
}
