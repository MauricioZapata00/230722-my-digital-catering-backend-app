package com.booking.digital.catering.business.client;

import com.booking.digital.catering.business.ClientRepository;
import com.booking.digital.catering.business.DuplicatedUserException;
import com.booking.digital.catering.business.SaveClientUseCase;
import com.digital.catering.domain.model.business.Client;
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
        return Boolean.FALSE.equals(isClientPersisted) ? this.clientRepository.saveClient(clientToSave) :  Mono.error(DuplicatedUserException.DuplicatedUserType
                .EMAIL_ALREADY_EXIST.build(new Throwable("Client with email: " + clientToSave.getEmail() + " already exists")));
    }
}
