package com.enviro.assessment.grad001.sandilemremi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.enviro.assessment.grad001.sandilemremi.model.WasteCategory;


/**
 * Repository interface for managing waste categories.
 *
 * This interface extends JpaRepository to provide CRUD operations for the
 * WasteCategory entity. 
 */


@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}