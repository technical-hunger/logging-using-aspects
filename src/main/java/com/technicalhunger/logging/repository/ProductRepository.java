package com.technicalhunger.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technicalhunger.logging.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
