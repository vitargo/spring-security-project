package org.vitargo.springsecuritysection9.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection9.model.AccountTransactions;


@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
