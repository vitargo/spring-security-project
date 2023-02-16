package org.vitargo.springsecuritysection10.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String role;

    @Column(name = "create_dt")
    private Date createDt;

//    @JsonIgnore
    @OneToMany ( fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Set<Authority> authorities;
}
