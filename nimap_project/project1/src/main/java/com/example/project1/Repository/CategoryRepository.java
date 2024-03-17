package com.example.project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
