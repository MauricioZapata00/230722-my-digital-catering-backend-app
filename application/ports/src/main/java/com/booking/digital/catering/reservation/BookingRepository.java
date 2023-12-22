package com.booking.digital.catering.reservation;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookingRepository {
    Flux<Booking> getBookingsByClientId(Long clientId);
    Flux<Booking> getBookingsByEmployeeId(Long employeeId);
    Mono<Booking> saveBooking(Booking booking);
    Mono<Booking> updateBooking(Booking booking);
    Mono<Void> deleteBooking(Booking booking);
}
