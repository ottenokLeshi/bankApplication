package com.ottenokleshi.bankproject.services;

import com.ottenokleshi.bankproject.models.entity.Client;

import java.util.Map;

public interface ClientService {
    public void save(Client client);
    public Map<String, Object> getClientAccounts(Long id);
}
