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

import com.quynhtd.source_code_final.entity.Category;
import com.quynhtd.source_code_final.service.CategoryService;

@Controller
@Transactional 
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public List<Category> getAllCategorys() {
//        return CategoryService.getAllCategorys();
//    }
    
    @RequestMapping(value = { "category-list" }, method = RequestMethod.GET)
    public String getAllCategorys(Model model) {
        List<Category> category = categoryService.getAllCategorys();
        model.addAttribute("categorys", category);
        return "category"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "category-add" }, method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "category-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @RequestMapping(value = { "category-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return updatedCategory != null ?
                ResponseEntity.ok(updatedCategory) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "category/{id}" }, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
