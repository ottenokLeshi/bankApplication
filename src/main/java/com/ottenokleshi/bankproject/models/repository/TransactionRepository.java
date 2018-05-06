package com.ottenokleshi.bankproject.models.repository;

import com.ottenokleshi.bankproject.models.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query(value = "select * FROM transaction where account_id = :id OR target_account_id = :id ORDER BY id", nativeQuery = true)
    Iterable<Transaction> findAccountTransactions(@Param("id") Long id);
}
