package com.enviro.assessment.grad001.sandilemremi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;
import com.enviro.assessment.grad001.sandilemremi.services.recycling.RecyclingTipSvc;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/tips")
public class RecyclingTipController {
    private final RecyclingTipSvc recyclingTipSvc;

    public RecyclingTipController(RecyclingTipSvc recyclingTipSvc) {
        this.recyclingTipSvc = recyclingTipSvc;
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        return ResponseEntity.ok(recyclingTipSvc.getAllRecyclingTips());

    }

    @GetMapping("/{tipId}")
    public ResponseEntity<Optional<RecyclingTip>> getSpecificTip(@PathVariable Long tipId) {
        return ResponseEntity.ok(recyclingTipSvc.getSpecificTip(tipId));
    }

    @GetMapping("/category/{tipId}")
    public ResponseEntity<List<RecyclingTip>> getTipByCategory(@PathVariable Long tipId) {
        return ResponseEntity.ok(recyclingTipSvc.getTipByCategory(tipId));
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@RequestBody RecyclingTip recyclingTip) {
        return new ResponseEntity<>(recyclingTipSvc.createTip(recyclingTip), HttpStatus.CREATED);
       
    }

    @PutMapping("/{tipId}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long tipId, @RequestBody RecyclingTip recyclingTip) {
        return new ResponseEntity<>(recyclingTipSvc.updateTip(tipId, recyclingTip), HttpStatus.OK);
    }
    
    @DeleteMapping("/{tipId}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long tipId) {
        recyclingTipSvc.deleteTip(tipId);
        return ResponseEntity.noContent().build();
    }
    
    
    


}