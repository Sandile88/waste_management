package com.enviro.assessment.grad001.sandilemremi.services.recycling;

import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;

public interface RecyclingTipSvc {

    public List<RecyclingTip> getAllRecyclingTips();

    public Optional<RecyclingTip> getSpecificTip(Long tipId);

    public RecyclingTip getTipByCategory(Long categoryId);

    public RecyclingTip createTip(RecyclingTip recyclingTip);

    public RecyclingTip updateTip(Long tipId, RecyclingTip updatedTip);

    public RecyclingTip deleteTip(Long tipId);

}