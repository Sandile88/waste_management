package com.enviro.assessment.grad001.sandilemremi.services.guideline;

import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;

public interface DisposalGuidelineSvc {

    public List<DisposalGuideline> getAllGuidelines();

    public Optional<DisposalGuideline> getSpecificGuideline(Long guidelineId);

    public DisposalGuideline getGuidelineByCategory(Long categoryId);

    public DisposalGuideline createGuideline(DisposalGuideline disposalGuideline);

    public DisposalGuideline updateGuideline(Long guidelineId, DisposalGuideline updatedGuideline);

    void deleteGuideline(Long guidelineId);

    
}