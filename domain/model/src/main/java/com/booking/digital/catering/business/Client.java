package com.booking.digital.catering.business;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class Client {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private Boolean isEnabled;
    private List<Long> bookingsIds;
}
