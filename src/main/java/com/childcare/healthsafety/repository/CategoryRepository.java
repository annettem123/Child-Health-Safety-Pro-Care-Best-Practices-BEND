package com.childcare.healthsafety.repository;

import com.childcare.healthsafety.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);

}
