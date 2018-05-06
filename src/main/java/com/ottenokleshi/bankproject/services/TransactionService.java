package com.ottenokleshi.bankproject.services;

import java.util.Map;

public interface TransactionService {
    public Map<String, Object> getAccountTransactions(Long clientId);
    public Map<String, Object> getAllTransactions();
}
