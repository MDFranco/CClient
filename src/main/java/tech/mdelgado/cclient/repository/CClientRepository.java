package tech.mdelgado.cclient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.mdelgado.cclient.model.Client;

public interface CClientRepository extends MongoRepository<Client, String> {

    Client findClientByFirstNameAndLastName(String firstName, String LastName);
}
