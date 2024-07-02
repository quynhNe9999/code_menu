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

import com.quynhtd.source_code_final.entity.Supplier;
import com.quynhtd.source_code_final.service.SupplierService;

@Controller
@Transactional 
public class SupplierController {


    @Autowired
    private SupplierService supplierService;

//    @GetMapping
//    public List<Supplier> getAllSuppliers() {
//        return SupplierService.getAllSuppliers();
//    }
    
    @RequestMapping(value = { "supplier-list" }, method = RequestMethod.GET)
    public String getAllSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "supplier-add" }, method = RequestMethod.GET)
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long id) {
        Optional<Supplier> supplier = supplierService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "supplier-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier createdSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplier);
    }

    @RequestMapping(value = { "supplier-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return updatedSupplier != null ?
                ResponseEntity.ok(updatedSupplier) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "supplier/{id}" }, method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable("id") Long id) {
        boolean deleted = supplierService.deleteSupplier(id);
        return "redirect:/supplier-list";

//        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
