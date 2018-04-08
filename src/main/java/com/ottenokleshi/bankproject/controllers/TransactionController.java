package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.entity.Transaction;
import com.ottenokleshi.bankproject.models.entity.TransactionType;
import com.ottenokleshi.bankproject.models.repository.AccountRepository;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import com.ottenokleshi.bankproject.models.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;

    /**
     * Получение всех транзакций по счету
     */
    @GetMapping("/transactions/{accountid}")
    public ModelAndView handler(@PathVariable(name = "accountid") Long accountId) {
        Iterable<Transaction> transactions = transactionRepository.findAccountTransactions(accountId);
        Account account = accountRepository.findById(accountId).get();
        Client client = clientRepository.findById(account.getClientId()).get();
        Map<String, Object> map = new HashMap<>();
        map.put("transactions", transactions);
        map.put("account", account);
        map.put("client", client);

        return new ModelAndView("transaction", map);
    }

    /**
     * Получение всех транзакций
     */
    @GetMapping("/transactions")
    public ModelAndView index() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("transactions", transactions);

        return new ModelAndView("transaction", map);
    }
}
