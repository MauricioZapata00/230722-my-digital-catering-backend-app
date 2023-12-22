package com.booking.digital.catering.business;

import reactor.core.publisher.Mono;

public interface EmployeeRepository {
    Mono<Employee> saveEmployee(Employee client);
    Mono<Employee> getSingleEmployeeById(Long id);
    Mono<Employee> getSingleEmployeeByEmail(String email);
    Mono<Employee> updateEmployee(Employee client);
    Mono<Void> deleteEmployee(Employee client);
}
