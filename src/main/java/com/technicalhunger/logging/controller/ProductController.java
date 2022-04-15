package com.technicalhunger.logging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalhunger.logging.config.Loggable;
import com.technicalhunger.logging.entity.Product;
import com.technicalhunger.logging.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	@Loggable
	public ResponseEntity<?> getAllProducts(){
		
		List<Product> products = productService.findAll();
		if(products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@Loggable
	public ResponseEntity<?> getProduct(@PathVariable Long id){
		
		try{
			Product product = productService.findById(id);
			return new ResponseEntity(product, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	@Loggable
	public ResponseEntity<?> addProduct(@RequestBody Product product){

		Product createdProduct = productService.save(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}
}
