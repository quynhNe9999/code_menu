package com.quynhtd.source_code_final.controller.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtd.source_code_final.entity.Employee;
import com.quynhtd.source_code_final.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@Transactional 
public class EmployeesController {


    @Autowired
    private EmployeeService employeeService;

//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return EmployeeService.getAllEmployees();
//    }
    
    @RequestMapping(value = { "employee-list" }, method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();
//        model.addAttribute("employees", employee);
        model.addAttribute("employees", employee);

        return "employee"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "employee-add" }, method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "employee-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @RequestMapping(value = { "employee-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return updatedEmployee != null ?
                ResponseEntity.ok(updatedEmployee) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "employee/{id}" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return "redirect:/employee-list";

//        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
