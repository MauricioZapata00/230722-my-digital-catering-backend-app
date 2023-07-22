package com.digital.catering.domain.model.reservation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class Category {
    private Long id;
    private String name;
    private String imageUrl;
    private List<Long> productsIds;
}
