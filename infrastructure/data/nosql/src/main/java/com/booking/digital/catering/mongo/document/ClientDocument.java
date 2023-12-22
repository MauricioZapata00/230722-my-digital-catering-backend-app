package com.booking.digital.catering.mongo.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Document(collation = "Client_Collection")
public class ClientDocument {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private Boolean isEnabled;
    private List<Long> bookingsIds;
}
