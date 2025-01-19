package com.enviro.assessment.grad001.sandilemremi.services.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;

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
       if (wasteCategoryRepository.existsById(categoryId)) {
        return wasteCategoryRepository.save(updatedWasteCategory);

       } else {
        throw new RuntimeException("Waste Category with ID: " + categoryId + " could not be found");
       }
    }

    // to be fixed
    @Override
    public void deleteCategory(Long categoryId) {
        throw new UnsupportedOperationException();

    //    return wasteCategoryRepository.delete((findById(categoryId)));
    }

}