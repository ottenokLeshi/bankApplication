package com.ottenokleshi.bankproject.models.repository;

import com.ottenokleshi.bankproject.models.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}

