package com.enviro.assessment.grad001.sandilemremi.model;



import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // @Column(name = "description")
    private String description;

    // @OneToMany(mappedBy = "wasteCategory")
    private List<DisposalGuideline> guidelines;

    // @OneToMany(mappedBy = "wasteCategory")
    private List<RecyclingTip> recyclingTips;

    
    // getters and setters
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<DisposalGuideline> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(List<DisposalGuideline> guidelines) {
        this.guidelines = guidelines;
    }

    
    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }




    
}
