package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Customer;
import com.quynhtd.source_code_final.respository.CustomerRepository;

@Service
public class CustomerService {
	  @Autowired
	    private CustomerRepository customerRepository;

	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public Optional<Customer> getCustomerById(Long id) {
	        return customerRepository.findById(id);
	    }

	    public Customer createCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    public Customer updateCustomer(Long id, Customer customer) {
	        if (customerRepository.existsById(id)) {
	            customer.setId(id);
	            return customerRepository.save(customer);
	        }
	        return null;
	    }

	    public boolean deleteCustomer(Long id) {
	        if (customerRepository.existsById(id)) {
	            customerRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}