package com.digital.catering.domain.ports.reservation;

import com.digital.catering.domain.model.reservation.Rating;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RatingRepository {
    Flux<Rating> getAllRatingsByProductId(Long productId);
    Flux<Rating> getAllRatingsByClientId(Long clientId);
    Mono<Rating> saveRating(Rating rating);
    Mono<Rating> updateRating(Rating rating);
    Mono<Void> deleteRating(Rating rating);
}
