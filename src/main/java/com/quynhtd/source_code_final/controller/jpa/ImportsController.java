package com.quynhtd.source_code_final.controller.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtd.source_code_final.entity.Imports;
import com.quynhtd.source_code_final.entity.Store;
import com.quynhtd.source_code_final.service.ImportService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@Transactional 
public class ImportsController {


    @Autowired
    private ImportService importService;

//    @GetMapping
//    public List<Imports> getAllImportss() {
//        return ImportsService.getAllImportss();
//    }
    
    @RequestMapping(value = { "imports-list" }, method = RequestMethod.GET)
    public String getAllImportss(Model model) {
        List<Imports> imports = importService.getAllImportss();
        model.addAttribute("imports", imports);
        return "imports"; // Trả về tên của view để render
    }

    @RequestMapping(value = { "imports-add" }, method = RequestMethod.GET)
    public String getStoreAdd( Model model) {
//        Optional<Store> Store = storeService.getStoreById(id);
    	Imports imports = new Imports();
		model.addAttribute("imports", imports);
		return "imports-add";
    }

    @RequestMapping(value = { "imports-list" }, method = RequestMethod.POST)
    public String createStore(@ModelAttribute("store")  Imports imports) {
    	importService.createImports(imports);
        return"redirect:/imports-list";
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }

    @RequestMapping(value = { "imports-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Imports> updateImports(@PathVariable("id") Long id, @RequestBody Imports imports) {
        Imports updatedImports = importService.updateImports(id, imports);
        return updatedImports != null ?
                ResponseEntity.ok(updatedImports) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "imports/{id}" }, method = RequestMethod.GET)
    public String deleteImports(@PathVariable("id") Long id) {
        boolean deleted = importService.deleteImports(id);
        return "redirect:/imports-list";

//        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
