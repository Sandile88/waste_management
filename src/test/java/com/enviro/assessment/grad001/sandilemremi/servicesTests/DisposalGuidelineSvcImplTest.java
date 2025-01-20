package com.enviro.assessment.grad001.sandilemremi.servicesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.sandilemremi.services.guideline.DisposalGuidelineSvcImpl;

@ExtendWith(MockitoExtension.class)
public class DisposalGuidelineSvcImplTest {
    
    @Mock
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Mock
    private WasteCategoryRepository wasteCategoryRepository;

    @InjectMocks
    private DisposalGuidelineSvcImpl disposalGuidelineSvc;

    private DisposalGuideline disposalGuideline;
    private WasteCategory category;

    @BeforeEach
    void setUp() {
        category = new WasteCategory();
        category.setId(1L);
        category.setName("Paper");

        disposalGuideline = new DisposalGuideline();
        disposalGuideline.setId(1L);
        disposalGuideline.setTitle("Paper Recycling Guide");
        disposalGuideline.setInstructions("Proper paper disposal methods\"");
        disposalGuideline.setDosList(Arrays.asList("Remove staples", "Keep paper dry", "Bundle similar types together"));
        disposalGuideline.setDontsList(Arrays.asList("Don't include greasy paper", "Don't mix with plastic", "Don't include thermal paper"));
        disposalGuideline.setWasteCategory(category);
    }

    @Test
    void testGetAllDisposalGuidelines() {
        List<DisposalGuideline> expectedGuidelines = Arrays.asList(disposalGuideline);
        when(disposalGuidelineRepository.findAll()).thenReturn(expectedGuidelines);

        List<DisposalGuideline> actualGuidelines = disposalGuidelineSvc.getAllGuidelines();

        assertEquals(expectedGuidelines, actualGuidelines);
        verify(disposalGuidelineRepository).findAll();
    }

    @Test
    void testGetSpecificGuideline() {
        when(disposalGuidelineRepository.findById(1L)).thenReturn(Optional.of(disposalGuideline));

        Optional<DisposalGuideline> result = disposalGuidelineSvc.getSpecificGuideline(1L);

        assertTrue(result.isPresent());
        assertEquals(disposalGuideline, result.get());
        verify(disposalGuidelineRepository).findById(1L);
    }
}