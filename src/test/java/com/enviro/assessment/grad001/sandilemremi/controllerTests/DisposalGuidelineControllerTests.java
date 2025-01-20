package com.enviro.assessment.grad001.sandilemremi.controllerTests;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

import com.enviro.assessment.grad001.sandilemremi.controller.DisposalGuidelineController;
import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.services.guideline.DisposalGuidelineSvc;

import java.util.Arrays;
import java.util.Optional;


@WebMvcTest(DisposalGuidelineController.class)
public class DisposalGuidelineControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DisposalGuidelineSvc disposalGuidelineSvc;

    
    @Test
    void testRetrivingAllGuidelines() throws Exception {
        DisposalGuideline guide1 = new DisposalGuideline();
        guide1.setId(1L);
        guide1.setTitle("Plastic Bottle Disposal Guide");

        DisposalGuideline guide2 = new DisposalGuideline();
        guide2.setId(2L);
        guide2.setTitle("Paper Recycling Guide");

        when(disposalGuidelineSvc.getAllGuidelines())
            .thenReturn(Arrays.asList(guide1, guide2));

        mockMvc.perform(get("/api/guidelines"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$.[0].title").value("Plastic Bottle Disposal Guide"));
    }

    @Test
    void testRetrivingOneGuideline() throws Exception {
        DisposalGuideline guide = new DisposalGuideline();
        guide.setId(1L);
        guide.setTitle("Plastic Bottle Disposal Guide");

        when(disposalGuidelineSvc.getSpecificGuideline(1L))
            .thenReturn(Optional.of(guide));

        mockMvc.perform(get("/api/guidelines/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.title").value("Plastic Bottle Disposal Guide"));
    }
}