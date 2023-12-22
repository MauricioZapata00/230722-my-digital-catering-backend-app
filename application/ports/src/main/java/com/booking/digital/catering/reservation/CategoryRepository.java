package com.booking.digital.catering.reservation;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository {
    Mono<Category> findSingleCategoryById(Long id);
    Mono<Category> findSingleCategoryByName(String name);
    Mono<Category> createCategory(Category category);
    Mono<Category> updateCategory(Category category);
}
