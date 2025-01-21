package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.CategoryEntity;
import com.sconexsoft.ecom.model.Category;
import com.sconexsoft.ecom.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepo.findAll();
        return categoryEntities.stream()
                .map(this::convertEntityToModel)  // Converting Entity to Model
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id)
                .map(this::convertEntityToModel); // Converting Entity to Model
    }

    @Override
    public Category addCategory(Category category) {
        CategoryEntity entity = convertModelToEntity(category); // Converting Model to Entity
        CategoryEntity savedEntity = categoryRepo.save(entity);
        return convertEntityToModel(savedEntity); // Converting Entity to Model
    }

    @Override
    public Category updateCategory(Category category) {
        if (categoryRepo.existsById(category.getId())) {
            CategoryEntity entity = convertModelToEntity(category); // Converting Model to Entity
            CategoryEntity updatedEntity = categoryRepo.save(entity);
            return convertEntityToModel(updatedEntity); // Converting Entity to Model
        }
        throw new IllegalArgumentException("Category with ID " + category.getId() + " does not exist.");
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Conversion method: Entity to Model
    private Category convertEntityToModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }

    // Conversion method: Model to Entity
    private CategoryEntity convertModelToEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        return categoryEntity;
    }
}
