package com.booking.digital.catering.mongo.repository;

import com.booking.digital.catering.mongo.document.ClientDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientPersistence extends ReactiveMongoRepository<ClientDocument, Long> {

    Mono<ClientDocument> findClientDocumentById(Long id);

    Mono<ClientDocument> findClientDocumentByEmail(String email);
}
