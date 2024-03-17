package com.example.project1.ProductResponse;

import com.example.project1.Model.Category;
import com.example.project1.Model.Product;

public class ProductResponse {
    private Product product;
    private Category category;
	public ProductResponse(Product product2, Category category2) {
		// TODO Auto-generated constructor stub
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
