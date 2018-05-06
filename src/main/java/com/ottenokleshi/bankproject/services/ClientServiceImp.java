package com.ottenokleshi.bankproject.services;

import com.ottenokleshi.bankproject.models.entity.Account;
import com.ottenokleshi.bankproject.models.entity.Client;
import com.ottenokleshi.bankproject.models.entity.Transaction;
import com.ottenokleshi.bankproject.models.entity.TransactionType;
import com.ottenokleshi.bankproject.models.repository.AccountRepository;
import com.ottenokleshi.bankproject.models.repository.ClientRepository;
import com.ottenokleshi.bankproject.models.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Map<String, Object> getClientAccounts(Long id) {
        Iterable<Account> accounts = accountRepository.findClientAccounts(id);
        Client client = clientRepository.findById(id).get();
        Map<String, Object> map = new HashMap<>();
        map.put("accounts", accounts);
        map.put("client", client);
        map.put("account", new Account());
        map.put("transaction", new Transaction());
        map.put("transfer", TransactionType.TRANSFER);
        return map;
    }
}
