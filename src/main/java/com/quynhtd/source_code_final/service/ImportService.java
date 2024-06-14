package com.quynhtd.source_code_final.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Imports;
import com.quynhtd.source_code_final.respository.ImportsRepository;

@Service
public class ImportService {
    @Autowired
    private ImportsRepository importsRepository;

    public List<Imports> getAllImports() {
        return importsRepository.findAll();
    }

    public Imports getImportById(Long id) {
        return importsRepository.findById(id).orElse(null);
    }

    public Imports saveImport(Imports imports) {
        return importsRepository.save(imports);
    }

    public void deleteImport(Long id) {
        importsRepository.deleteById(id);
    }
}