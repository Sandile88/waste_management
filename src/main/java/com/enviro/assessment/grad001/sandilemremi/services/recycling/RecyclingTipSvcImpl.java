package com.enviro.assessment.grad001.sandilemremi.services.recycling;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;

@Service
public class RecyclingTipSvcImpl implements RecyclingTipSvc {

    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRecyclingTips'");
    }

    @Override
    public RecyclingTip getSpecificTip(Long tipId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpecificTip'");
    }

    @Override
    public RecyclingTip getTipByCategory(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipByCategory'");
    }

    @Override
    public RecyclingTip createTip(RecyclingTip recyclingTip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTip'");
    }

    @Override
    public RecyclingTip updateTip(Long tipId, RecyclingTip updatedTip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTip'");
    }

    @Override
    public RecyclingTip deleteTip(Long tipId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTip'");
    }

}