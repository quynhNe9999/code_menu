package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Supplier;
import com.quynhtd.source_code_final.repository.SupplierRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SupplierService {
	  @Autowired
	    private SupplierRepository supplierRepository;

	    public List<Supplier> getAllSuppliers() {
	        return supplierRepository.findAll();
	    }

	    public Optional<Supplier> getSupplierById(Long id) {
	        return supplierRepository.findById(id);
	    }

	    public Supplier createSupplier(Supplier supplier) {
	        return supplierRepository.save(supplier);
	    }

	    public Supplier updateSupplier(Long id, Supplier supplier) {
	        if (supplierRepository.existsById(id)) {
	        	supplier.setId(id);
	            return supplierRepository.save(supplier);
	        }
	        return null;
	    }

	    public boolean deleteSupplier(Long id) {
	        if (supplierRepository.existsById(id)) {
	        	supplierRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}