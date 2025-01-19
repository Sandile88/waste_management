package com.enviro.assessment.grad001.sandilemremi.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;

@Service
public class WasteCategorySvcImpl implements WasteCategorySvc {

    @Override
    public List<WasteCategory> getAllWasteCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllWasteCategory'");
    }

    @Override
    public WasteCategory getSpecificCategory(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpecifiCategory'");
    }

    @Override
    public WasteCategory createCategory(WasteCategory wasteCategory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCategory'");
    }

    @Override
    public WasteCategory updateCategory(Long categoryId, WasteCategory updatedWasteCategory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public WasteCategory deleteCategory(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

}