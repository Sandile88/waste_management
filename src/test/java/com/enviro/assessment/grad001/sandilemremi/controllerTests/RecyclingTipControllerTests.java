package com.enviro.assessment.grad001.sandilemremi.controllerTests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.enviro.assessment.grad001.sandilemremi.controller.RecyclingTipController;
import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.services.recycling.RecyclingTipSvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RecyclingTipController.class)
public class RecyclingTipControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecyclingTipSvc recyclingTipSvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    private RecyclingTip testTip;
    private WasteCategory testCategory;

    @BeforeEach
    void setUp() {
        testCategory = new WasteCategory();
        testCategory.setId(1L);
        testCategory.setName("Plastic");

        testTip = new RecyclingTip();
        testTip.setId(1L);
        testTip.setTitle("Efficient Plastic Recycling");
        testTip.setDescription("Tips for better plastic recycling at home");
        testTip.setWasteCategory(testCategory);
    }


    @Test
    void testGetTipByCategory() throws Exception {
        List<RecyclingTip> tips = Collections.singletonList(testTip);
        when(recyclingTipSvc.getTipByCategory(1L)).thenReturn(tips);

        mockMvc.perform(get("/tips/category/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].title").value("Efficient Plastic Recycling"));
    }

    @Test
    void testCreateTip() throws Exception {
        when(recyclingTipSvc.createTip(any(RecyclingTip.class))).thenReturn(testTip);

        mockMvc.perform(post("/tips")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(testTip)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.title").value("Efficient Plastic Recycling"))
            .andExpect(jsonPath("$.description").value("Tips for better plastic recycling at home"));
    }
}