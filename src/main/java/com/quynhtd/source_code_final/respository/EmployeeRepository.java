package com.quynhtd.source_code_final.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtd.source_code_final.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
   
}
