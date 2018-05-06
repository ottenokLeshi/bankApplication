package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class ClientController {

    @Autowired
    ClientServiceImp clientServiceImp;


    /**
     * Создание клиента из формы
     */
    @PostMapping("/client")
    public RedirectView postClient(@ModelAttribute Client client) {
        clientServiceImp.save(client);
        return new RedirectView("/");
    }

    /**
     * Получение счетов клиента
     */
    @GetMapping("/client/{id}")
    public ModelAndView handler(@PathVariable(name = "id") Long id) {
        Map<String, Object> map = clientServiceImp.getClientAccounts(id);

        return new ModelAndView("client", map);
    }
}
