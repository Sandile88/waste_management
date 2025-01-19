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

    // to be fixed
    @Override
    public RecyclingTip getTipByCategory(Long categoryId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RecyclingTip createTip(RecyclingTip recyclingTip) {
      return recyclingTipRepository.save(recyclingTip);
    }

    @Override
    public RecyclingTip updateTip(Long tipId, RecyclingTip updatedTip) {
        if (recyclingTipRepository.existsById(tipId)) {
            return recyclingTipRepository.save(updatedTip);

        } else {
        throw new RuntimeException("Waste Category with ID: " + tipId + " could not be found");
        }
    }
    

    // to be fixed
    @Override
    public void deleteTip(Long tipId) {
        throw new UnsupportedOperationException();

        // return recyclingTipRepository.delete((findById(tipId)));
    }

}