package com.enviro.assessment.grad001.sandilemremi.modelTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;


public class WasteCategoryModelTests {

    @Test
    void testWasteCategoryCreation() {
        WasteCategory tip = new WasteCategory();
        assertNotNull(tip);
    }


    @Test
    void testWasteCategoryObj() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setId(1L);
        wasteCategory.setName("Glass");
        wasteCategory.setDescription("Recyclable glass items such as bottles and jars.");

        List<DisposalGuideline> guidelines = Arrays.asList(new DisposalGuideline(), new DisposalGuideline());
        List<RecyclingTip> recyclingTips = Arrays.asList(new RecyclingTip(), new RecyclingTip());

        wasteCategory.setGuidelines(guidelines);
        wasteCategory.setRecyclingTips(recyclingTips);

        assertNotNull(wasteCategory);
        assertEquals(1L, wasteCategory.getId());
        assertEquals("Glass", wasteCategory.getName());
        assertEquals("Recyclable glass items such as bottles and jars.", wasteCategory.getDescription());
        assertEquals(2, wasteCategory.getGuidelines().size());
        assertEquals(2, wasteCategory.getRecyclingTips().size());
    }
}