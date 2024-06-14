package com.quynhtd.source_code_final.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Store;
import com.quynhtd.source_code_final.respository.StoreRepository;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllstores() {
        return storeRepository.findAll();
    }

    public Store getstoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store savestore(Store store) {
        return storeRepository.save(store);
    }

    public void deletestore(Long id) {
        storeRepository.deleteById(id);
    }
}