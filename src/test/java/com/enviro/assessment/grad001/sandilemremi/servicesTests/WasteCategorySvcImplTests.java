package com.enviro.assessment.grad001.sandilemremi.servicesTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.sandilemremi.services.category.WasteCategorySvcImpl;


@ExtendWith(MockitoExtension.class)
public class WasteCategorySvcImplTests {
    
    @Mock
    private WasteCategoryRepository wasteCategoryRepository;
    
    private WasteCategorySvcImpl wasteCategorySvcImpl;
    private WasteCategory wasteCategory;
    
    
    @BeforeEach
    void setUp() {
        wasteCategorySvcImpl = new WasteCategorySvcImpl(wasteCategoryRepository);
        
        wasteCategory = new WasteCategory();
        wasteCategory.setId(1L);
        wasteCategory.setName("Metal");
        wasteCategory.setDescription("Recyclable metal items such as cans and scrap.");
        List<DisposalGuideline> guidelines = Arrays.asList(new DisposalGuideline(), new DisposalGuideline());
        List<RecyclingTip> recyclingTips = Arrays.asList(new RecyclingTip(), new RecyclingTip());
        wasteCategory.setGuidelines(guidelines);
        wasteCategory.setRecyclingTips(recyclingTips);        
    }


    @Test
    void testUpdateCategory() {
        WasteCategory updatedCategory = new WasteCategory();
        updatedCategory.setName("Metal Recycling");
        updatedCategory.setDescription("Includes aluminum cans, steel, and scrap metal.");
        
        when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.of(wasteCategory));
        when(wasteCategoryRepository.save(any(WasteCategory.class))).thenReturn(wasteCategory);
        
        WasteCategory result = wasteCategorySvcImpl.updateCategory(1L, updatedCategory);
        assertEquals("Metal Recycling", result.getName());
        assertEquals("Includes aluminum cans, steel, and scrap metal.", result.getDescription());
        verify(wasteCategoryRepository).findById(1L);
        verify(wasteCategoryRepository).save(any(WasteCategory.class));
    }


    @Test
    void testUpdateInvalidCategoryId() {
        when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.empty());
        
        assertThrows(RuntimeException.class, () -> wasteCategorySvcImpl.updateCategory(1L, wasteCategory));
        verify(wasteCategoryRepository).findById(1L);
        verify(wasteCategoryRepository, never()).save(any(WasteCategory.class));
    }


    @Test
    void testDeleteCategory() {
        when(wasteCategoryRepository.existsById(1L)).thenReturn(true);
        
        wasteCategorySvcImpl.deleteCategory(1L);
        verify(wasteCategoryRepository).existsById(1L);
        verify(wasteCategoryRepository).deleteById(1L);
    }


    @Test
    void testDeleteInvalidCategoryId() {
        when(wasteCategoryRepository.existsById(1L)).thenReturn(false);
        
        assertThrows(RuntimeException.class, () -> wasteCategorySvcImpl.deleteCategory(1L));
        verify(wasteCategoryRepository).existsById(1L);
        verify(wasteCategoryRepository, never()).deleteById(any());
    }
}