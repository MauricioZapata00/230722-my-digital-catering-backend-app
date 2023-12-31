package com.digital.catering.domain.ports.business;

import com.digital.catering.domain.model.business.Client;
import reactor.core.publisher.Mono;

public interface ClientRepository {
    Mono<Client> saveClient(Client client);
    Mono<Client> getSingleClientById(Long id);
    Mono<Client> getSingleClientByEmail(String email);
    Mono<Client> updateClient(Client client);
    Mono<Void> deleteClient(Client client);
}
