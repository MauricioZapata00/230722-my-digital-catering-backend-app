package com.digital.catering.infrastructure.application.rest.business;

import com.digital.catering.application.usecase.SaveClientUseCase;
import com.digital.catering.domain.model.business.Client;
import com.digital.catering.infrastructure.application.rest.business.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Scope("application")
@RequestMapping("/api/v1/business/client")
@RequiredArgsConstructor
public class ClientController {

    private final SaveClientUseCase saveClientUseCase;

    @PostMapping
    public Mono<ClientDTO> createClient(@RequestBody ClientDTO clientToCreate){
        return this.saveClientUseCase.process(this.mapDtoToModel(clientToCreate))
                .map(this::mapModelToDto);
    }

    private Client mapDtoToModel(ClientDTO dto){
        return Client.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .isEnabled(dto.getIsEnabled())
                .bookingsIds(dto.getBookingsIds())
                .build();
    }

    private ClientDTO mapModelToDto(Client model){
        return new ClientDTO(model.getId(), model.getName(), model.getLastName(), model.getPassword(),
                model.getEmail(), model.getIsEnabled(), model.getBookingsIds());
    }
}
