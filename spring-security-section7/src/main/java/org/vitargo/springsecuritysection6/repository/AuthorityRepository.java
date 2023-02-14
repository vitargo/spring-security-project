package org.vitargo.springsecuritysection6.repository;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.springsecuritysection6.model.Authority;

import java.util.Set;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Set<Authority> getAuthoritiesByCustomerId(int customerId);
}
