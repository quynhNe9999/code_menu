package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Store;
import com.quynhtd.source_code_final.repository.StoreRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class StoreService {
	  @Autowired
	    private StoreRepository storeRepository;

	    public List<Store> getAllStores() {
	        return storeRepository.findAll();
	    }

	    public Optional<Store> getStoreById(Long id) {
	        return storeRepository.findById(id);
	    }

	    public Store createStore(Store store) {
	        return storeRepository.save(store);
	    }

	    public Store updateStore(Long id, Store store) {
	        if (storeRepository.existsById(id)) {
	            store.setId(id);
	            return storeRepository.save(store);
	        }
	        return null;
	    }

	    public boolean deleteStore(Long id) {
	        if (storeRepository.existsById(id)) {
	            storeRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}