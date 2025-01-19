package com.enviro.assessment.grad001.sandilemremi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.sandilemremi.model.RecyclingTip;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {

    List<RecyclingTip> findByWasteCategoryId(Long wasteCategoryId);

}