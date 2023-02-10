package org.vitargo.springsecuritysection5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection5.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findCustomerByEmail(String email);
}
