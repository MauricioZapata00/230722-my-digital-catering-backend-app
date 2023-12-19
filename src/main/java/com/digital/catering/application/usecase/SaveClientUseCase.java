package com.digital.catering.application.usecase;

import com.digital.catering.domain.model.business.Client;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveClientUseCase {

    Mono<Client> process(Client client);
}
