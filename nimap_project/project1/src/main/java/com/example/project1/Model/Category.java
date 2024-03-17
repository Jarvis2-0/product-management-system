package com.example.project1.Model;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    
    private String categoryName;


	
	@OneToMany(mappedBy="category")
	
	private List<Product> products;



	public Long getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Category(Long categoryId, String categoryName, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.products = products;
	}



	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}

	
	
}


