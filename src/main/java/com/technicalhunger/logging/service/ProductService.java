package com.technicalhunger.logging.service;

import java.util.List;
import java.util.Optional;

import com.technicalhunger.logging.entity.Product;


public interface ProductService {

	List<Product> findAll();
	
	Product findById(long id);
	
	Product save(Product product);
}
