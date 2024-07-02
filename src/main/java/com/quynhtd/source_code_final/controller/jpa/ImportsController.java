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

import com.quynhtd.source_code_final.entity.Imports;
import com.quynhtd.source_code_final.service.ImportService;

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
    public ResponseEntity<Imports> getImportsById(@PathVariable("id") Long id) {
        Optional<Imports> imports = importService.getImportsById(id);
        return imports.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "imports-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Imports> createImports(@RequestBody Imports imports) {
        Imports createdImports = importService.createImports(imports);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdImports);
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
