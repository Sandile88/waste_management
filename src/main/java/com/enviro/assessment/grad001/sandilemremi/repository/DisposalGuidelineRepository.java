package com.enviro.assessment.grad001.sandilemremi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.sandilemremi.model.DisposalGuideline;
import java.util.List;


/**
 * Repository interface for managing disposal guidelines.
 *
 * This interface extends JpaRepository to provide CRUD operations for the
 * DisposalGuideline entity. It includes a method to find disposal guidelines
 * by waste category ID, allowing retrieval of guidelines associated with
 * specific waste categories.
 */


@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByWasteCategoryId(Long wasteCategoryId);
}
