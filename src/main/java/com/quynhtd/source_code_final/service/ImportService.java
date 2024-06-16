package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Imports;
import com.quynhtd.source_code_final.repository.ImportsRepository;

@Service
public class ImportService {
	  @Autowired
	    private ImportsRepository importsRepository;

	    public List<Imports> getAllImportss() {
	        return importsRepository.findAll();
	    }

	    public Optional<Imports> getImportsById(Long id) {
	        return importsRepository.findById(id);
	    }

	    public Imports createImports(Imports imports) {
	        return importsRepository.save(imports);
	    }

	    public Imports updateImports(Long id, Imports imports) {
	        if (importsRepository.existsById(id)) {
	            imports.setId(id);
	            return importsRepository.save(imports);
	        }
	        return null;
	    }

	    public boolean deleteImports(Long id) {
	        if (importsRepository.existsById(id)) {
	        	importsRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}