package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/account")
    public RedirectView postAccount(@ModelAttribute Account account) {
        accountRepository.save(account);
        return new RedirectView("/client/" + account.getClientId());
    }
}
