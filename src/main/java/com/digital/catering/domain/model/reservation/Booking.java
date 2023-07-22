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
    private List<Long> productsIds;
    private Long clientId;
    private Double price;
}
