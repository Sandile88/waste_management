package com.enviro.assessment.grad001.sandilemremi.services.recycling;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.repository.RecyclingTipRepository;

@Service
public class RecyclingTipSvcImpl implements RecyclingTipSvc {

    private final RecyclingTipRepository recyclingTipRepository;

    public RecyclingTipSvcImpl(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
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
      return recyclingTipRepository.save(recyclingTip);
    }

    @Override
    public RecyclingTip updateTip(Long tipId, RecyclingTip updatedTip) {
       return recyclingTipRepository.findById(tipId)
       .map(existingTip -> {
        existingTip.setTitle(updatedTip.getTitle());
        existingTip.setDescription(updatedTip.getDescription());
        
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