package com.quynhtd.source_code_final.controller.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtd.source_code_final.entity.Store;
import com.quynhtd.source_code_final.service.StoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Transactional 
public class StoreController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

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
    public String getStoreAdd( Model model) {
//        Optional<Store> Store = storeService.getStoreById(id);
        Store store = new Store();
		model.addAttribute("store", store);
		return "store-add";
    }

    @RequestMapping(value = { "store-list" }, method = RequestMethod.POST)
    public String createStore(@ModelAttribute("store")  Store Store) {
        storeService.createStore(Store);
        return"redirect:/store-list";
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }
//
    @RequestMapping(value = { "/store-edit/{id}" }, method = RequestMethod.GET)
	public String editStore(@PathVariable Long id, Model model) {
		model.addAttribute("stores", storeService.getStoreById(id));
		return "store-update";
	}

    @RequestMapping(value = { "store-list/{id}" }, method = RequestMethod.POST)
	public String updateStudent(@PathVariable Long id, @ModelAttribute("stores") Store stores, Model model) {

		// get student from database by id
		Optional<Store> store = storeService.getStoreById(id);
		stores.setId(id);
		stores.setName(stores.getName());
		stores.setEmail(stores.getEmail());
		stores.setPhoneNumber(stores.getPhoneNumber());
		stores.setAddress(stores.getAddress());

		// save updated student object
		storeService.updateStore(id,stores);
		return "redirect:/store-list";
	}
//    
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)  
//    public String editStore(@RequestParam("id") Long Id, Model model) {  
//      Optional<Store> StoreEdit = storeService.getStoreById(Id);  
//      StoreEdit.ifPresent(Store -> model.addAttribute("stores", Store));  
//      return "store-update";  
//    }  
//
//    @RequestMapping(value = "save", method = RequestMethod.POST)  
//    public String save(Store Store) {  
//      storeService.createStore(Store);  
//      return "redirect:/store-list";  
//    }  
//    
    
    
    
//    @RequestMapping(value = { "store-edit/{id}" }, method = RequestMethod.PUT)
//    public ResponseEntity<Store> updateStore(@PathVariable("id") Long id, @RequestBody Store Store) {
//        Store updatedStore = storeService.updateStore(id, Store);
//        return updatedStore != null ?
//                ResponseEntity.ok(updatedStore) :
//                ResponseEntity.notFound().build();
//    }

    @RequestMapping(value = { "store/{id}" }, method = RequestMethod.GET)
    public String deleteStore(@PathVariable("id") Long id) {
        boolean deleted = storeService.deleteStore(id);
        return "redirect:/store-list";

        //        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
