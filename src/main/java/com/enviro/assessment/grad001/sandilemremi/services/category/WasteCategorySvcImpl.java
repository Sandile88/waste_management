package com.enviro.assessment.grad001.sandilemremi.services.category;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;


/**
 * Implementation of the WasteCategorySvc interface.
 *
 * This class provides the concrete implementation of the methods
 * defined in the WasteCategorySvc interface for managing waste categories.
 */


@Service
public class WasteCategorySvcImpl implements WasteCategorySvc {

    private final WasteCategoryRepository wasteCategoryRepository;
    

    public WasteCategorySvcImpl(WasteCategoryRepository wasteCategoryRepository){
        this.wasteCategoryRepository = wasteCategoryRepository;
    }


    @Override
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }


    @Override
    public Optional<WasteCategory> getSpecificCategory(Long categoryId) {
       return wasteCategoryRepository.findById(categoryId);
    }


    @Override
    public WasteCategory createCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }


    @Override
    public WasteCategory updateCategory(Long categoryId, WasteCategory updatedWasteCategory) {
       return wasteCategoryRepository.findById(categoryId)
       .map(existingCategory -> {
        existingCategory.setName(updatedWasteCategory.getName());
        existingCategory.setDescription(updatedWasteCategory.getDescription());

        return wasteCategoryRepository.save(existingCategory);
       })
       .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
    }


    @Override
    public void deleteCategory(Long categoryId) {
        if(wasteCategoryRepository.existsById(categoryId)) {
            wasteCategoryRepository.deleteById(categoryId);
        } else {
            throw new RuntimeException("Waste Category with ID: " + categoryId + " could not be found");
       }
    }
}