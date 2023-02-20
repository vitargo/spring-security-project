package org.vitargo.springsecuritysection13.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection13.model.Loans;


@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
//    @PreAuthorize("hasRole('USER')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
