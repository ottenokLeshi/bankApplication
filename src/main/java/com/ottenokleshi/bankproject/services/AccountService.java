package com.ottenokleshi.bankproject.services;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Transaction;

public interface AccountService {
    public void transferTransaction(Transaction transaction, Long clientId);
    public void save(Account account);
}
