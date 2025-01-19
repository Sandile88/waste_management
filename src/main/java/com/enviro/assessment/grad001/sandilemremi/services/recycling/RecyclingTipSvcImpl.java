package com.enviro.assessment.grad001.sandilemremi.services.recycling;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;

@Service
public class RecyclingTipSvcImpl implements RecyclingTipSvc {

    private final RecyclingTipRepository recyclingTipRepository;
    private final WasteCategoryRepository wasteCategoryRepository;


    public RecyclingTipSvcImpl(RecyclingTipRepository recyclingTipRepository, WasteCategoryRepository wasteCategoryRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
       return recyclingTipRepository.findAll();
    }

    @Override
    public Optional<RecyclingTip> getSpecificTip(Long tipId) {
        return recyclingTipRepository.findById(tipId);
        
    }

    @Override
    public List<RecyclingTip> getTipByCategory(Long categoryId) {
        return recyclingTipRepository.findByWasteCategoryId(categoryId);
    }

    @Override
    public RecyclingTip createTip(RecyclingTip recyclingTip) {
        if(recyclingTip.getWasteCategory() != null && recyclingTip.getWasteCategory().getId() != null) {
            WasteCategory category = wasteCategoryRepository.findById(recyclingTip.getWasteCategory().getId())
            .orElseThrow(() -> new RuntimeException("Category not found with ID: " + 
                recyclingTip.getWasteCategory().getId()));
            recyclingTip.setWasteCategory(category);
        }
      return recyclingTipRepository.save(recyclingTip);
    }

    @Override
    public RecyclingTip updateTip(Long tipId, RecyclingTip updatedTip) {
       return recyclingTipRepository.findById(tipId)
       .map(existingTip -> {
        existingTip.setTitle(updatedTip.getTitle());
        existingTip.setDescription(updatedTip.getDescription());

        if(updatedTip.getWasteCategory() != null && updatedTip.getWasteCategory().getId() != null) {
            WasteCategory category = wasteCategoryRepository.findById(updatedTip.getWasteCategory().getId())
            .orElseThrow(() -> new RuntimeException("Category not found with ID: " + 
                updatedTip.getWasteCategory().getId()));
            existingTip.setWasteCategory(category);
        }        
        return recyclingTipRepository.save(existingTip);
       })
       .orElseThrow(() -> new RuntimeException("Recycling tip not found with ID: " + tipId));
    }
    

    @Override
    public void deleteTip(Long tipId) {
       if (recyclingTipRepository.existsById(tipId)) {
        recyclingTipRepository.deleteById(tipId);
       } else {
        throw new RuntimeException("Recyling Tip with ID: " + tipId + " could not be found");
       }
    }

}