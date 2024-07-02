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

import com.quynhtd.source_code_final.entity.Store;
import com.quynhtd.source_code_final.service.StoreService;

@Controller
@Transactional 
public class StoreController {


    @Autowired
    private StoreService storeService;

//    @GetMapping
//    public List<Store> getAllStores() {
//        return StoreService.getAllStores();
//    }
    
    @RequestMapping(value = { "store-list" }, method = RequestMethod.GET)
    public String getAllStores(Model model) {
        List<Store> stores = storeService.getAllStores();
        model.addAttribute("stores", stores);
        return "stores"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "store-add" }, method = RequestMethod.GET)
    public ResponseEntity<Store> getStoreById(@PathVariable("id") Long id) {
        Optional<Store> Store = storeService.getStoreById(id);
        return Store.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "store-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Store> createStore(@RequestBody Store Store) {
        Store createdStore = storeService.createStore(Store);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }

    @RequestMapping(value = { "store-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Store> updateStore(@PathVariable("id") Long id, @RequestBody Store Store) {
        Store updatedStore = storeService.updateStore(id, Store);
        return updatedStore != null ?
                ResponseEntity.ok(updatedStore) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "store/{id}" }, method = RequestMethod.GET)
    public String deleteStore(@PathVariable("id") Long id) {
        boolean deleted = storeService.deleteStore(id);
        return "redirect:/store-list";

        //        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
