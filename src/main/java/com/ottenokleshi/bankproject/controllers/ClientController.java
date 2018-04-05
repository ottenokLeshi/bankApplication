package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.repository.AccountRepository;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/client/{id}")
    public ModelAndView handler(@PathVariable(name = "id") Long id) {
        Iterable<Account> accounts = accountRepository.findClientAccounts(id);
        Client client = clientRepository.findById(id).get();
        Map<String, Object> map = new HashMap<>();
        map.put("accounts", accounts);
        map.put("client", client);
        map.put("account", new Account());

        return new ModelAndView("client", map);
    }

    @PostMapping("/client")
    public RedirectView postClient(@ModelAttribute Client client) {
        clientRepository.save(client);

        return new RedirectView("/");
    }

    public static class AccountController {
    }
}
