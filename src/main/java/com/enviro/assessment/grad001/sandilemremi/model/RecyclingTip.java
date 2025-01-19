package com.enviro.assessment.grad001.sandilemremi.model;


import jakarta.persistence.*;

@Entity
@Table(name = "recyling_tips")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne()
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategoryId;

    // @Column(name = "description")
    private String description;


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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    
}
