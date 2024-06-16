package com.quynhtd.source_code_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtd.source_code_final.entity.Brand;
import com.quynhtd.source_code_final.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {
   
}
