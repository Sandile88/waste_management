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

    @ManyToOne
    @JoinColumn(name = "waste_category_id")
    private WasteCategory wasteCategory;

    @ElementCollection
    @CollectionTable(name = "dos_list", joinColumns = @JoinColumn(name = "guideline_id"))
    @Column(name = "dos")
    private List<String> dosList;

    @ElementCollection
    @CollectionTable(name = "donts_list", joinColumns = @JoinColumn(name = "guideline_id"))
    @Column(name = "donts")
    private List<String> dontsList;

    @Column(name = "instructions")
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


    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
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
