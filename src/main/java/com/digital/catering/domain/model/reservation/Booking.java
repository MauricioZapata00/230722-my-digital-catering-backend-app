package com.digital.catering.domain.model.reservation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class Booking {
    private Long id;
    private Long creationDate;
    private Long bookingDate;
    private Double latitude;
    private Double longitude;
    private List<Long> productsIds;
    private Long clientId;
    private Long employeeId;
    private Double price;
}
