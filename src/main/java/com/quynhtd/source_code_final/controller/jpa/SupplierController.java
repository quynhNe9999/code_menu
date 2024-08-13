package com.quynhtd.source_code_final.controller.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtd.source_code_final.entity.Supplier;
import com.quynhtd.source_code_final.service.SupplierService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@Transactional 
public class SupplierController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SupplierService supplierService;
    
    @RequestMapping(value = { "suppliers-list" }, method = RequestMethod.GET)
    public String getAllSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers"; // Trả về tên của view để render
    }

    @RequestMapping(value = { "suppliers-add" }, method = RequestMethod.GET)
    public String getSupplierById( Model model) {
        Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		return "suppliers-add";
    }

    @RequestMapping(value = { "suppliers-list" }, method = RequestMethod.POST)
    public String createSupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.createSupplier(supplier);
      return"redirect:/suppliers-list";
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
    }
}
