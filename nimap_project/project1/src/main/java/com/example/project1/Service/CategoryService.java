package com.example.project1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.project1.Model.Category;
import com.example.project1.Repository.CategoryRepository;

@Service

public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

	public List<Category> getAllCategories(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return categoryRepository.findAll(PageRequest.of(page, size)).getContent();
	}

	public Category createCategory(Category category) {
	
				return categoryRepository.save(category);
	}

	public Category getCategoryById(Long id) {
		try {
			return categoryRepository.findById(id).get();
		}
		catch (Exception e) {
			return null;
		}
		
	}

	public Category updateCategory(Long id, Category category) {
        try {
            Category dbCategory = categoryRepository.findById(id).orElse(null);
            if (dbCategory != null) {
                dbCategory.setCategoryName(category.getCategoryName());
                categoryRepository.save(dbCategory);
                System.out.println("Category updated successfully.");
                return dbCategory;
            } else {
                System.out.println("Category with ID " + id + " not found, so update failed.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Failed to update category.");
            return null;
        }
    }

	

	public Category deleteCategory(Long id, Category category) {
	    try {
	        Category dbcategory = categoryRepository.findById(id).orElse(null);
	        
	        if (dbcategory != null) {
	            dbcategory.setCategoryName(category.getCategoryName());
	            categoryRepository.save(dbcategory);
	            return dbcategory;
	        } else {
	            return null; // Or handle the case where category with given id is not found
	        }
	    } catch (Exception e) {
	        return null;
	    }

	}
	}

