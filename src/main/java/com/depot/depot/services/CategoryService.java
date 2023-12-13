package com.depot.depot.services;

import com.depot.depot.entities.Category;
import com.depot.depot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        // You can perform additional checks/validation here before saving
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        System.out.println("id: " + id);
        System.out.println("updatedCategory: " + updatedCategory);
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setId(id);
            category.setName(updatedCategory.getName());
            category.setReference(updatedCategory.getReference());
            return categoryRepository.save(category);
        }
        return null;
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}