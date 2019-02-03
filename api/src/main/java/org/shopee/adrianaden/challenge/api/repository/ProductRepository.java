package org.shopee.adrianaden.challenge.api.repository;

import org.shopee.adrianaden.challenge.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
