package com.ottenokleshi.bankproject.controllers;

import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Получение начальной страницы с клиентами и формой добавления клиента
     */
    @GetMapping("/")
    public ModelAndView index() {
        Optional<Iterable<Client>> clients = Optional.of(clientRepository.findActiveClients());
        Map<String, Object> map = new HashMap<>();
        if (clients.isPresent()) {
            map.put("clients", clients.get());
        }
        Client client = new Client();
        map.put("client", client);

        return new ModelAndView("index", map);
    }
}
