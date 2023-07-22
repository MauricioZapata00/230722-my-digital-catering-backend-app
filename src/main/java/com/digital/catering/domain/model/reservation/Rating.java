package com.digital.catering.domain.model.reservation;

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
