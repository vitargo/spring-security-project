package org.vitargo.springsecuritysection8.repository;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.springsecuritysection8.model.Authority;

import java.util.Set;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Set<Authority> getAuthoritiesByCustomerId(int customerId);
}
