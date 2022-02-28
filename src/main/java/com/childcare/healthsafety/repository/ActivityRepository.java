package com.childcare.healthsafety.repository;

import com.childcare.healthsafety.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByCategoryId(Long activityId);
}

