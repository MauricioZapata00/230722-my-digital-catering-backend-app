package com.digital.catering.domain.ports.business;

import com.digital.catering.domain.model.business.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {
    Mono<Employee> saveEmployee(Employee client);
    Mono<Employee> getSingleEmployeeById(Long id);
    Mono<Employee> getSingleEmployeeByEmail(String email);
    Mono<Employee> updateEmployee(Employee client);
    Mono<Void> deleteEmployee(Employee client);
}
