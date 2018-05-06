package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.services.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    TransactionServiceImp transactionServiceImp;

    /**
     * Получение всех транзакций по счету
     */
    @GetMapping("/transactions/{accountid}")
    public ModelAndView handler(@PathVariable(name = "accountid") Long accountId) {
        Map<String, Object> map = transactionServiceImp.getAccountTransactions(accountId);
        return new ModelAndView("transaction", map);
    }

    /**
     * Получение всех транзакций
     */
    @GetMapping("/transactions")
    public ModelAndView index() {
        Map<String, Object> map = transactionServiceImp.getAllTransactions();
        return new ModelAndView("transaction", map);
    }
}
