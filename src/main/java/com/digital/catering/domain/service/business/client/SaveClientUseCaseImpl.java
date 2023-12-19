package com.digital.catering.domain.service.business.client;

import com.digital.catering.application.usecase.SaveClientUseCase;
import com.digital.catering.domain.exception.reservation.DuplicatedResourceException;
import com.digital.catering.domain.model.business.Client;
import com.digital.catering.domain.ports.business.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveClientUseCaseImpl implements SaveClientUseCase {

    private final ClientRepository clientRepository;
    @Override
    public Mono<Client> process(Client client) {
        return this.clientRepository.getSingleClientById(client.getId())
                .hasElement().flatMap(isClientPersisted -> this.createClientIfNotPersisted(isClientPersisted, client));
    }

    private Mono<Client> createClientIfNotPersisted(Boolean isClientPersisted, Client clientToSave){
        return Boolean.FALSE.equals(isClientPersisted) ? this.clientRepository.saveClient(clientToSave) :  Mono.error(DuplicatedResourceException.DuplicatedResourceType
                        .RESOURCE_NAME_ALREADY_EXIST.build(new Throwable("Client with email: " + clientToSave.getEmail() + " already exists")));
    }
}
