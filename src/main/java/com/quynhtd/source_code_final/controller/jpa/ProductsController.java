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

import com.quynhtd.source_code_final.entity.Product;
import com.quynhtd.source_code_final.service.ProductService;

@Controller
@Transactional 
public class ProductsController {


    @Autowired
    private ProductService productService;

//    @GetMapping
//    public List<Product> getAllProducts() {
//        return ProductService.getAllProducts();
//    }
    
    @RequestMapping(value = { "product-list" }, method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        List<Product> product = productService.getAllProducts();
        model.addAttribute("products", product);
        return "product"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "product-add" }, method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> Product = productService.getProductById(id);
        return Product.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "product-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @RequestMapping(value = { "product-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ?
                ResponseEntity.ok(updatedProduct) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "Product/{id}" }, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
