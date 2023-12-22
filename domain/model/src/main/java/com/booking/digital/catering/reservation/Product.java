package com.booking.digital.catering.reservation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer minimumQuantity;
    private Boolean isPreviousPaymentRequired;
    private Integer minimumDaysForBooking;
    private Boolean isChangesAllowed;
    private Long categoryId;
    private List<Long> ratingsIds;
    private List<Long> bookingsIds;
}
