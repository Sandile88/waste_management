package com.enviro.assessment.grad001.sandilemremi.modelTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;


public class DisposalGuidelineModelTests {

    @Test
    void testDisposalGuidelineCreation() {
        DisposalGuideline guideline = new DisposalGuideline();
        assertNotNull(guideline);
    }


    @Test
    void testCompleteGuidelineObj() {
        DisposalGuideline guideline = new DisposalGuideline();

        guideline.setId(1L);
        guideline.setTitle("Metal Recycling Guidelines");
        guideline.setInstructions("Follow these instructions to recycle metal properly.");
        guideline.setDosList(Arrays.asList("Do rinse all cans before recycling", "Do keep metal items separated"));
        guideline.setDontsList(Arrays.asList("Don't include non-metal items in the recycling", "Don't throw away scrap metal"));

        WasteCategory category = new WasteCategory();
        category.setId(1L);
        category.setName("Metal");
        guideline.setWasteCategory(category);

        assertNotNull(guideline);
        assertEquals(1L, guideline.getId());
        assertEquals("Metal Recycling Guidelines", guideline.getTitle());
        assertEquals("Follow these instructions to recycle metal properly.", guideline.getInstructions());
        assertEquals(2, guideline.getDosList().size());
        assertEquals(2, guideline.getDontsList().size());
        assertNotNull(guideline.getWasteCategory());
    }
}