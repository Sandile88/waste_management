package com.enviro.assessment.grad001.sandilemremi.services.guideline;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;

@Service
public class DisposalGuidelineSvcImpl implements DisposalGuidelineSvc {

    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final WasteCategoryRepository wasteCategoryRepository;

    public DisposalGuidelineSvcImpl(DisposalGuidelineRepository disposalGuidelineRepository, WasteCategoryRepository wasteCategoryRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public List<DisposalGuideline> getAllGuidelines() {
       return disposalGuidelineRepository.findAll();
    }

    @Override
    public Optional<DisposalGuideline> getSpecificGuideline(Long guidelineId) {
       return disposalGuidelineRepository.findById(guidelineId);
    }

    @Override
    public List<DisposalGuideline> getGuidelineByCategory(Long categoryId) {
        return disposalGuidelineRepository.findByWasteCategoryId(categoryId);

    }

    @Override
    public DisposalGuideline createGuideline(DisposalGuideline disposalGuideline) {
        if (disposalGuideline.getWasteCategory() != null && disposalGuideline.getWasteCategory().getId() != null) {
            WasteCategory category = wasteCategoryRepository.findById(disposalGuideline.getWasteCategory().getId())
            .orElseThrow(() -> new RuntimeException("Category not found with ID: " +
                disposalGuideline.getWasteCategory().getId()));
            disposalGuideline.setWasteCategory(category);
        }
       return disposalGuidelineRepository.save(disposalGuideline);
    }

    @Override
    public DisposalGuideline updateGuideline(Long guidelineId, DisposalGuideline updatedGuideline) {
        return disposalGuidelineRepository.findById(guidelineId)
        .map(existingGuideline -> {
            existingGuideline.setTitle(updatedGuideline.getTitle());
            existingGuideline.setInstructions(updatedGuideline.getInstructions());
            existingGuideline.setDosList(updatedGuideline.getDosList());
            existingGuideline.setDontsList(updatedGuideline.getDontsList());

            if (updatedGuideline.getWasteCategory() != null && updatedGuideline.getWasteCategory().getId() != null) {
                WasteCategory category = wasteCategoryRepository.findById(updatedGuideline.getWasteCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " +
                    updatedGuideline.getWasteCategory().getId()));
                existingGuideline.setWasteCategory(category);
            }
            return disposalGuidelineRepository.save(existingGuideline);
        })
        .orElseThrow(() -> new RuntimeException("Guideline not found with ID: " + guidelineId));
    }

    @Override
    public void deleteGuideline(Long guidelineId) {
        if(disposalGuidelineRepository.existsById(guidelineId)) {
            disposalGuidelineRepository.deleteById(guidelineId);
        } else {
            throw new RuntimeException("Disposal Guideline with ID: " + guidelineId + " could not be found");

        }

    }

}