package com.enviro.assessment.grad001.sandilemremi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import java.util.List;


@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

    
    List<DisposalGuideline> findByWasteCategoryId(Long wasteCategoryId);
}
