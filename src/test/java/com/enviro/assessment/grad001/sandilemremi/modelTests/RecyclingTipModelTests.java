package com.enviro.assessment.grad001.sandilemremi.modelTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;


public class RecyclingTipModelTests {

    @Test
    void testRecyclingTipCreation() {
        RecyclingTip tip = new RecyclingTip();
        assertNotNull(tip);
    }


    @Test
    void testRecyclingTipObj() {
        RecyclingTip tip = new RecyclingTip();
        tip.setId(1L);
        tip.setTitle("Glass Recycling Tip");
        tip.setDescription("Always rinse glass jars and bottles before recycling.");
      
        WasteCategory category = new WasteCategory();
        category.setId(1L);
        category.setName("Glass");
        tip.setWasteCategory(category);

        assertNotNull(tip);
        assertEquals(1L, tip.getId());
        assertEquals("Glass Recycling Tip", tip.getTitle());
        assertEquals("Always rinse glass jars and bottles before recycling.", tip.getDescription());
        assertNotNull(tip.getWasteCategory());
    }
}