package com.quynhtd.source_code_final.controller.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtd.source_code_final.entity.Customer;
import com.quynhtd.source_code_final.service.CustomerService;

@Controller
@Transactional
public class CustomerController {


    @Autowired
    private CustomerService customerService;

//    @GetMapping
//    public List<Customer> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
    
    @RequestMapping(value = { "customer-list" }, method = RequestMethod.GET)
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "customer-add" }, method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "customer-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @RequestMapping(value = { "customer-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return updatedCustomer != null ?
                ResponseEntity.ok(updatedCustomer) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "customer/{id}" }, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        boolean deleted = customerService.deleteCustomer(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
