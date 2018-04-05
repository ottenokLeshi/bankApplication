package com.ottenokleshi.bankproject.models.repository;

import com.ottenokleshi.bankproject.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}

