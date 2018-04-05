package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Transaction;
import com.ottenokleshi.bankproject.models.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transactions/{id}")
    public ModelAndView handler(@PathVariable(name = "id") Long id) {
        String result = "";
        try {
            Iterable<Transaction> transactions = transactionRepository.findAll();
            Map<String, Iterable<Transaction>> map = new HashMap<>();
            map.put("transactions", transactions);
            return new ModelAndView("index", map);
        } catch (NoSuchElementException exception) {
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return new ModelAndView("index");
    }
}
