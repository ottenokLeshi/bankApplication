package com.ottenokleshi.bankproject.models.repository;

import com.ottenokleshi.bankproject.models.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query(value = "select * FROM client where is_active = TRUE ORDER BY id", nativeQuery = true)
    Iterable<Client> findActiveClients();
}

