package com.enviro.assessment.grad001.sandilemremi.services.category;

import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;

public interface WasteCategorySvc {

    public List<WasteCategory> getAllCategories();

    public Optional<WasteCategory> getSpecificCategory(Long categoryId);

    public WasteCategory createCategory(WasteCategory wasteCategory);

    public WasteCategory updateCategory(Long categoryId, WasteCategory updatedWasteCategory);

    void deleteCategory(Long categoryId);
}
