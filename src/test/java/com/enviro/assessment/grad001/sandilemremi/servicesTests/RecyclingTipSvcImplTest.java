package com.enviro.assessment.grad001.sandilemremi.servicesTests;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.sandilemremi.services.recycling.RecyclingTipSvcImpl;


@ExtendWith(MockitoExtension.class)
public class RecyclingTipSvcImplTest {

    @Mock
    private RecyclingTipRepository recyclingTipRepository;

    @Mock
    private WasteCategoryRepository wasteCategoryRepository;

    @InjectMocks
    private RecyclingTipSvcImpl recyclingTipService;

    private RecyclingTip sampleTip;
    private WasteCategory sampleCategory;


    @BeforeEach
    void setUp() {
        sampleCategory = new WasteCategory();
        sampleCategory.setId(1L);
        sampleCategory.setName("Plastic");

        sampleTip = new RecyclingTip();
        sampleTip.setId(1L);
        sampleTip.setTitle("Plastic Recycling");
        sampleTip.setDescription("How to recycle plastic");
        sampleTip.setWasteCategory(sampleCategory);
    }


    @Test
    void getTipByCategory() {
        List<RecyclingTip> expectedTips = Arrays.asList(sampleTip);
        when(recyclingTipRepository.findByWasteCategoryId(1L)).thenReturn(expectedTips);

        List<RecyclingTip> actualTips = recyclingTipService.getTipByCategory(1L);
        assertEquals(expectedTips, actualTips);
        verify(recyclingTipRepository).findByWasteCategoryId(1L);
    }

    @Test
    void createTipWithValidCategory() {
        when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.of(sampleCategory));
        when(recyclingTipRepository.save(any(RecyclingTip.class))).thenReturn(sampleTip);

        RecyclingTip result = recyclingTipService.createTip(sampleTip);
        assertEquals(sampleTip, result);
        verify(wasteCategoryRepository).findById(1L);
        verify(recyclingTipRepository).save(any(RecyclingTip.class));
    }

    @Test
    void createTipWithInvalidCategory() {
        when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> recyclingTipService.createTip(sampleTip));
        verify(wasteCategoryRepository).findById(1L);
        verify(recyclingTipRepository, never()).save(any(RecyclingTip.class));
    }
}