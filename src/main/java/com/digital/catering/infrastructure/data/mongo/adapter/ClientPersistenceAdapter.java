package com.digital.catering.infrastructure.data.mongo.adapter;

import com.digital.catering.domain.model.business.Client;
import com.digital.catering.domain.ports.business.ClientRepository;
import com.digital.catering.infrastructure.data.mongo.document.ClientDocument;
import com.digital.catering.infrastructure.data.mongo.repository.ClientPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;
import reactor.core.publisher.Mono;

@Repository
@ApplicationScope
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientRepository {

    private final ClientPersistence clientPersistence;
    @Override
    public Mono<Client> saveClient(Client client) {
        return this.clientPersistence.save(this.modelToDocument(client))
                .map(this::documentToModel);
    }

    @Override
    public Mono<Client> getSingleClientById(Long id) {
        return this.clientPersistence.findClientDocumentById(id)
                .map(this::documentToModel);
    }

    @Override
    public Mono<Client> getSingleClientByEmail(String email) {
        return this.clientPersistence.findClientDocumentByEmail(email)
                .map(this::documentToModel);
    }

    @Override
    public Mono<Client> updateClient(Client client) {
        return clientPersistence.save(this.modelToDocument(client))
                .map(this::documentToModel);
    }

    @Override
    public Mono<Void> deleteClient(Client client) {
        return this.clientPersistence.delete(this.modelToDocument(client));
    }

    private Client documentToModel(ClientDocument document){
        return Client.builder()
                .id(document.getId())
                .name(document.getName())
                .lastName(document.getLastName())
                .password(document.getPassword())
                .email(document.getEmail())
                .isEnabled(document.getIsEnabled())
                .bookingsIds(document.getBookingsIds())
                .build();
    }

    private ClientDocument modelToDocument(Client model){
        ClientDocument documentToMap = new ClientDocument();
        documentToMap.setId(model.getId());
        documentToMap.setName(model.getName());
        documentToMap.setLastName(model.getLastName());
        documentToMap.setPassword(model.getPassword());
        documentToMap.setEmail(model.getEmail());
        documentToMap.setIsEnabled(model.getIsEnabled());
        documentToMap.setBookingsIds(model.getBookingsIds());
        return documentToMap;
    }
}
