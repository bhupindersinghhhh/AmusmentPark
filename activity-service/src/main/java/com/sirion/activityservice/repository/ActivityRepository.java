package com.sirion.activityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirion.activityservice.entity.Activity;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    public List<Activity> findByChargesLessThanEqual(Double charges);
}
