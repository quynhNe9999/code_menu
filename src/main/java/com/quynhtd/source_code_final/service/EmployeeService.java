package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Employee;
import com.quynhtd.source_code_final.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeeService {
	  @Autowired
	    private EmployeeRepository employeeRepository;

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employee> getEmployeeById(Long id) {
	        return employeeRepository.findById(id);
	    }

	    public Employee createEmployee(Employee Employee) {
	        return employeeRepository.save(Employee);
	    }

	    public Employee updateEmployee(Long id, Employee Employee) {
	        if (employeeRepository.existsById(id)) {
	            Employee.setId(id);
	            return employeeRepository.save(Employee);
	        }
	        return null;
	    }

	    public boolean deleteEmployee(Long id) {
	        if (employeeRepository.existsById(id)) {
	        	employeeRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}