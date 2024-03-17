package com.example.project1.Model;

import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToOne
    
    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

	


    // Getters and setters
}

