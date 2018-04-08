package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Получение начальной страницы с клиентами и формой добавления клиента
     */
    @GetMapping("/")
    public ModelAndView index() {
        Iterable<Client> clients = clientRepository.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("clients", clients);
        map.put("client", new Client());

        return new ModelAndView("index", map);
    }
}
