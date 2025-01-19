package com.enviro.assessment.grad001.sandilemremi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;
import com.enviro.assessment.grad001.sandilemremi.services.category.WasteCategorySvc;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categories")
public class WasteCategoryController {
    private final WasteCategorySvc wasteCategorySvc;

    public WasteCategoryController(WasteCategorySvc wasteCategorySvc) {
        this.wasteCategorySvc = wasteCategorySvc;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(wasteCategorySvc.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Optional<WasteCategory>> getSpecificCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(wasteCategorySvc.getSpecificCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@RequestBody WasteCategory wasteCategory) {
        return new ResponseEntity<>(wasteCategorySvc.createCategory(wasteCategory), HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long categoryId, @RequestBody WasteCategory wasteCategory) {
        return new ResponseEntity<>(wasteCategorySvc.updateCategory(categoryId, wasteCategory), HttpStatus.OK);
    }


    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        wasteCategorySvc.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
    
    
    
}