package com.enviro.assessment.grad001.sandilemremi.controller;


import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sandilemremi.services.guideline.DisposalGuidelineSvc;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineSvc disposalGuidelineSvc;
    
    public DisposalGuidelineController(DisposalGuidelineSvc disposalGuidelineSvc) {
        this.disposalGuidelineSvc = disposalGuidelineSvc;
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines() {
        return ResponseEntity.ok(disposalGuidelineSvc.getAllGuidelines());
    }

    @GetMapping("/{guidelineId}")
    public ResponseEntity<Optional<DisposalGuideline>> getSpecificGuideline(@PathVariable Long guidelineId) {
        return ResponseEntity.ok(disposalGuidelineSvc.getSpecificGuideline(guidelineId));
    }

    @GetMapping("/category/{guidelineId}")
    public ResponseEntity<List<DisposalGuideline>> getGuidelineByCategory(@PathVariable Long guidelineId) {
        return ResponseEntity.ok(disposalGuidelineSvc.getGuidelineByCategory(guidelineId));
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        return new ResponseEntity<>(disposalGuidelineSvc.createGuideline(disposalGuideline), HttpStatus.CREATED);
    }


    @PutMapping("/{guidelineId}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long guidelineId, @RequestBody DisposalGuideline disposalGuideline) {
        return new ResponseEntity<>(disposalGuidelineSvc.updateGuideline(guidelineId, disposalGuideline), HttpStatus.OK);
    }

    @DeleteMapping("/{guidelineId}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long guidelineId) {
        disposalGuidelineSvc.deleteGuideline(guidelineId);
        return ResponseEntity.noContent().build();
    }
   
    
   
    

}