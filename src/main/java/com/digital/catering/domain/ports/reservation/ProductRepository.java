package com.digital.catering.domain.ports.reservation;

import com.digital.catering.domain.model.reservation.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository {
    Flux<Product> getAllStoredProducts();
    Flux<Product> getProductsAssociatedToSingleCategory(Long categoryId);
    Mono<Product> saveProduct(Product product);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProduct(Product product);
}
