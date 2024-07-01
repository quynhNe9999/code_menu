package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Category;
import com.quynhtd.source_code_final.repository.CategoryRepository;

@Service
public class CategoryService {
	  @Autowired
	    private CategoryRepository categoryRepository;

	    public List<Category> getAllCategorys() {
	        return categoryRepository.findAll();
	    }

	    public Optional<Category> getCategoryById(Long id) {
	        return categoryRepository.findById(id);
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Category updateCategory(Long id, Category category) {
	        if (categoryRepository.existsById(id)) {
	            category.setId(id);
	            return categoryRepository.save(category);
	        }
	        return null;
	    }

	    public boolean deleteCategory(Long id) {
	        if (categoryRepository.existsById(id)) {
	            categoryRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}