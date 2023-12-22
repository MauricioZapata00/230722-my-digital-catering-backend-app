package com.booking.digital.catering.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private Boolean isEnabled;
    private List<Long> bookingsIds;
}
