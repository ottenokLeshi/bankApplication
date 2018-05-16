package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class ClientController {

    @Autowired
    ClientServiceImp clientServiceImp;


    /**
     * Создание клиента из формы
     */
    @PostMapping("/client")
    public RedirectView postClient(@Valid @ModelAttribute Client client, BindingResult result) {
        if(result.hasErrors()) {
            return new RedirectView("/");
        }
        try {
            clientServiceImp.save(client);
        } catch (Exception e) {
            System.out.println("ERROR: email must be unique: " + e.getMessage());
        }
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

    /**
     * Удалить клиента
     */
    @DeleteMapping("/client/{id}")
    public RedirectView deleteClient(@PathVariable(name = "id") Long id) {
        clientServiceImp.desactivateClient(id);

        return new RedirectView("/");
    }
}
