package com.enviro.assessment.grad001.sandilemremi.model;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne()
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategoryId;

    @ElementCollection
    private List<String> dosList;

    @ElementCollection
    private List<String> dontsList;

    // @Column(name = "instructions")
    private String instructions;


    // getters and setters
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public WasteCategory getWasteCategoryId() {
        return wasteCategoryId;
    }

    public void setWasteCategoryId(WasteCategory wasteCategoryId) {
        this.wasteCategoryId = wasteCategoryId;
    }


    public List<String> getDosList() {
        return dosList;
    }

    public void setDosList(List<String> dosList) {
        this.dosList = dosList;
    }


    public List<String> getDontsList() {
        return dontsList;
    }

    public void setDontsList(List<String> dontsList) {
        this.dontsList = dontsList;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    
}
