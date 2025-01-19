package com.enviro.assessment.grad001.sandilemremi.services.guideline;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.repository.DisposalGuidelineRepository;

@Service
public class DisposalGuidelineSvcImpl implements DisposalGuidelineSvc {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    public DisposalGuidelineSvcImpl(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    @Override
    public List<DisposalGuideline> getAllGuidelines() {
       return disposalGuidelineRepository.findAll();
    }

    @Override
    public Optional<DisposalGuideline> getSpecificGuideline(Long guidelineId) {
       return disposalGuidelineRepository.findById(guidelineId);
    }

    // to be fixed
    @Override
    public DisposalGuideline getGuidelineByCategory(Long categoryId) {
        throw new UnsupportedOperationException();
    //    return disposalGuidelineRepository.findById(categoryId);
    }

    @Override
    public DisposalGuideline createGuideline(DisposalGuideline disposalGuideline) {
       return disposalGuidelineRepository.save(disposalGuideline);
    }

    @Override
    public DisposalGuideline updateGuideline(Long guidelineId, DisposalGuideline updatedGuideline) {
        if (disposalGuidelineRepository.existsById(guidelineId)) {
            return disposalGuidelineRepository.save(updatedGuideline);

        } else {
        throw new RuntimeException("Waste Category with ID: " + guidelineId + " could not be found");
        }
    }

    // to be fixed
    @Override
    public void deleteGuideline(Long guidelineId) {
        throw new UnsupportedOperationException();

        // return disposalGuidelineRepository.delete((findById(guidelineId)));

    }

}