package com.booking.digital.catering.reservation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Rating {
    private Long id;
    private Long clientId;
    private Long productId;
    private Double score;
}
