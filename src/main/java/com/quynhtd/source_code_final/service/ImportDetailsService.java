package com.quynhtd.source_code_final.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.ImportDetails;
import com.quynhtd.source_code_final.respository.ImportDetailsRepository;

@Service
public class ImportDetailsService {
    @Autowired
    private ImportDetailsRepository importDetailRepository;

    public List<ImportDetails> getAllImportDetails() {
        return importDetailRepository.findAll();
    }

    public ImportDetails getImportDetailById(Long id) {
        return importDetailRepository.findById(id).orElse(null);
    }

    public ImportDetails saveImportDetail(ImportDetails importDetails) {
        return importDetailRepository.save(importDetails);
    }

    public void deleteImportDetail(Long id) {
        importDetailRepository.deleteById(id);
    }
}