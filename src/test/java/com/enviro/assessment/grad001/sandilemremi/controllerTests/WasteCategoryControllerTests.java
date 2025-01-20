package com.enviro.assessment.grad001.sandilemremi.controllerTests;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.enviro.assessment.grad001.sandilemremi.controller.WasteCategoryController;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.services.category.WasteCategorySvc;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(WasteCategoryController.class)
public class WasteCategoryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WasteCategorySvc wasteCategorySvc;


    @Test
    void testUpdateCategory() throws Exception {
    WasteCategory existingCategory = new WasteCategory();
    existingCategory.setId(1L);
    existingCategory.setName("Paper");
    existingCategory.setDescription("Paper and cardboard materials");

    WasteCategory updatedCategory = new WasteCategory();
    updatedCategory.setId(1L);
    updatedCategory.setName("Paper Recycling");
    updatedCategory.setDescription("How to recycle paper at home");

    when(wasteCategorySvc.updateCategory(eq(1L), any(WasteCategory.class)))
            .thenReturn(updatedCategory);

    mockMvc.perform(put("/api/categories/{categoryId}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(updatedCategory)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value("Paper Recycling"))
            .andExpect(jsonPath("$.description").value("How to recycle paper at home"));
    }


    @Test 
    void testDeleteCategory() throws Exception {
        doNothing().when(wasteCategorySvc).deleteCategory(1L);

        mockMvc.perform(delete("/api/categories/{categoryId}", 1L))
            .andExpect(status().isNoContent());
    }
}