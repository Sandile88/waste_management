package com.enviro.assessment.grad001.sandilemremi.services.recycling;


import java.util.List;
import java.util.Optional;
import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;


/**
 * Service interface for managing recycling tips.
 *
 * This interface defines CRUD operations for recycling tips,
 * including methods to retrieve, create, update, and delete tips.
 */


public interface RecyclingTipSvc {

    public List<RecyclingTip> getAllRecyclingTips();

    public Optional<RecyclingTip> getSpecificTip(Long tipId);

    public List<RecyclingTip> getTipByCategory(Long categoryId);

    public RecyclingTip createTip(RecyclingTip recyclingTip);

    public RecyclingTip updateTip(Long tipId, RecyclingTip updatedTip);

    void deleteTip(Long tipId);

}