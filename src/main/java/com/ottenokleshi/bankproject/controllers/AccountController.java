package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Transaction;
import com.ottenokleshi.bankproject.services.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AccountController {

    @Autowired
    AccountServiceImp accountServiceImp;

    /**
     * Создание счета из формы
     */
    @PostMapping("/account")
    public RedirectView postAccount(@Valid @ModelAttribute Account account, BindingResult result) {
        if(result.hasErrors()) {
            return new RedirectView("/client/" + account.getClientId());
        }
        accountServiceImp.save(account);
        return new RedirectView("/client/" + account.getClientId());
    }

    /**
     * Создание перевода
     */
    @Transactional
    @PostMapping("/account/transfer/{clientId}")
    public RedirectView addUserTransferTransaction(@ModelAttribute Transaction transaction,
                                                   @PathVariable(name = "clientId") Long clientId) {
        accountServiceImp.transferTransaction(transaction, clientId);
        return new RedirectView("/client/" + clientId);
    }
}