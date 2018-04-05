package com.ottenokleshi.bankproject.models.repository;

import com.ottenokleshi.bankproject.models.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query(value = "select * FROM account where clientid = :id", nativeQuery = true)
    Iterable<Account> findClientAccounts(@Param("id") Long id);
}
