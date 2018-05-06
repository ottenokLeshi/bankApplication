package com.ottenokleshi.bankproject.services;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.entity.Transaction;
import com.ottenokleshi.bankproject.models.repository.AccountRepository;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import com.ottenokleshi.bankproject.models.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImp implements TransactionService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public Map<String, Object> getAccountTransactions(Long accountId){
        Iterable<Transaction> transactions = transactionRepository.findAccountTransactions(accountId);
        Account account = accountRepository.findById(accountId).get();
        Client client = clientRepository.findById(account.getClientId()).get();
        Map<String, Object> map = new HashMap<>();
        map.put("transactions", transactions);
        map.put("account", account);
        map.put("client", client);

        return map;
    }
    public Map<String, Object> getAllTransactions() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("transactions", transactions);
        return  map;
    }
}
