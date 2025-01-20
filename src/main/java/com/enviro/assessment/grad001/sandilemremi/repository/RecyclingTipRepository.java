package com.enviro.assessment.grad001.sandilemremi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;


/**
 * Repository interface for managing recycling tips.
 *
 * This interface extends JpaRepository to provide CRUD operations for the
 * RecyclingTip entity. It includes a method to find recycling tips
 * by waste category ID, allowing retrieval of tips associated with
 * specific waste categories.
 */


@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    List<RecyclingTip> findByWasteCategoryId(Long wasteCategoryId);
}