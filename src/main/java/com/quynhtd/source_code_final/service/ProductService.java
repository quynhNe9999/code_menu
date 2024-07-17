package com.quynhtd.source_code_final.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Product;
import com.quynhtd.source_code_final.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public void saveProduct(Product product) {
    	productRepository.save(product);	
	}


	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
        	product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
        	productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}