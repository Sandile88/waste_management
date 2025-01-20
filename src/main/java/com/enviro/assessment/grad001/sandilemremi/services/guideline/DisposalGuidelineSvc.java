package com.enviro.assessment.grad001.sandilemremi.services.guideline;


import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;


/**
 * Service interface for managing disposal guidelines.
 *
 * This interface defines CRUD operations for disposal guidelines,
 * including methods to retrieve, create, update, and delete guidelines.
 */

 
public interface DisposalGuidelineSvc {

    public List<DisposalGuideline> getAllGuidelines();

    public Optional<DisposalGuideline> getSpecificGuideline(Long guidelineId);

    public List<DisposalGuideline> getGuidelineByCategory(Long categoryId);

    public DisposalGuideline createGuideline(DisposalGuideline disposalGuideline);

    public DisposalGuideline updateGuideline(Long guidelineId, DisposalGuideline updatedGuideline);

    void deleteGuideline(Long guidelineId);

    
}