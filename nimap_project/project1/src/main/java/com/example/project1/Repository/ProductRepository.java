package com.example.project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
