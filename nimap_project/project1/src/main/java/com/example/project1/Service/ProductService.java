package com.example.project1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.project1.Model.Product;
import com.example.project1.Repository.CategoryRepository;
import com.example.project1.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Product> getAllProducts(Integer page, Integer size) {
    	return productRepository.findAll(PageRequest.of(page, size)).getContent();    }

    public Product createProduct(Product product) {
       
    	try {
    			product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()).get());
    		return productRepository.save(product);
        } catch (Exception e) {
            System.out.println("Failed to create product.");
            return null;
        }
    }

    public Product getProductById(Long id) {
        try {
            return productRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Failed to get product with ID: " + id);
            return null;
        }
    }

    public Product updateProduct(Long id, Product product) {
        try {
            Product dbProduct = productRepository.findById(id).orElse(null);
            if (dbProduct != null) {
                dbProduct.setName(product.getName());
                productRepository.save(dbProduct);
                System.out.println("Product updated successfully.");
                return dbProduct;
            } else {
                System.out.println("Product with ID " + id + " not found, so update failed.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Failed to update product.");
            return null;
        }
    }

    public void deleteProduct(Long id) {
        try {
            Product dbProduct = productRepository.findById(id).orElse(null);
            if (dbProduct != null) {
                productRepository.delete(dbProduct);
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product with ID " + id + " not found, so delete failed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to delete product.");
        }
    }
}
