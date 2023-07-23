package com.digital.catering.domain.model.business;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class Employee {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private Boolean isWorking;
    private List<Long> bookingsIds;
}
