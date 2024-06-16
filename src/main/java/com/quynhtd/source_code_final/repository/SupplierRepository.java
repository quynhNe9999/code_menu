package com.quynhtd.source_code_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtd.source_code_final.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>  {
   
}
