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
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TransactionRepository transactionRepository;

    /**
     * Создание счета из формы
     */
    @PostMapping("/account")
    public RedirectView postAccount(@ModelAttribute Account account) {
        accountRepository.save(account);
        return new RedirectView("/client/" + account.getClientId());
    }

    /**
     * Создание перевода
     */
    @PostMapping("/account/transfer/{clientId}")
    public RedirectView addUserTransferTransaction(@ModelAttribute Transaction transaction,
                                                   @PathVariable(name = "clientId") Long clientId) {

        Optional<Account> account = accountRepository.findById(transaction.getAccountId());
        Optional<Account> targetAccount = accountRepository.findById(transaction.getTargetAccountId());

        if (!account.isPresent() || !targetAccount.isPresent()) {
            //DOTO добавить редирект на ошибку
            return new RedirectView("/");
        }

        Client client = clientRepository.findById(account.get().getClientId()).get();
        Integer balance = account.get().getBalance();
        Integer targetBalance = targetAccount.get().getBalance();

        if (balance < transaction.getSumm() || clientId != account.get().getClientId()) {
            //DOTO добавить редирект на ошибку
            return new RedirectView("/");
        }

        account.get().setBalance(balance - transaction.getSumm());
        targetAccount.get().setBalance(targetBalance + transaction.getSumm());
        accountRepository.save(account.get());
        accountRepository.save(targetAccount.get());
        transaction.setType(TransactionType.TRANSFER);
        transaction.setTime(new Timestamp(new Date().getTime()));
        transactionRepository.save(transaction);

        return new RedirectView("/client/" + client.getId());
    }
}