package com.ottenokleshi.bankproject.models.repository;

import com.ottenokleshi.bankproject.models.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
