package com.technicalhunger.logging.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalhunger.logging.config.Loggable;
import com.technicalhunger.logging.entity.Product;
import com.technicalhunger.logging.repository.ProductRepository;
import com.technicalhunger.logging.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Loggable
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Loggable
	public Product findById(long id) {
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isPresent())
			return product.get();
		
		throw new RuntimeException("Product not exists!");
	}

	@Override
	@Loggable
	public Product save(Product product) {
		return productRepository.save(product);
	}
}
