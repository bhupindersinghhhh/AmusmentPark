package com.sirion.activityservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.activityservice.entity.Activity;
import com.sirion.activityservice.exception.IllegalActivityException;
import com.sirion.activityservice.repository.ActivityRepository;

@Service
public class ActivityService implements IActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity insertActivity(Activity activity) throws IllegalActivityException {
        Optional<Activity> activityOptional = activityRepository.findById(activity.getActivityId());
        if (!activityOptional.isPresent()) {
            return activityRepository.save(activity);
        } else {
            throw new IllegalActivityException("Activity already exists.");
        }
    }

    @Override
    public Activity updateActivity(Activity activity) throws IllegalActivityException {
        Optional<Activity> activityOptional = activityRepository.findById(activity.getActivityId());
        if (activityOptional.isPresent()) {
            return activityRepository.save(activity);
        } else {
            throw new IllegalActivityException("Activity does not exist.");
        }
    }

    @Override
    public Activity deleteActivity(int activityId) throws IllegalActivityException {
        Optional<Activity> activityOptional = activityRepository.findById(activityId);
        if (activityOptional.isPresent()) {
            activityRepository.delete(activityOptional.get());
            return activityOptional.get();
        } else {
            throw new IllegalActivityException("Activity does not exist.");
        }
    }

    @Override
    public List<Activity> viewActivitiesOfCharges(double charges) {
        List<Activity> activitiesList = activityRepository.findByChargesLessThanEqual(charges);
        return activitiesList;
    }

    @Override
    public List<Activity> getAllActivities() {
        List<Activity> activitiesList = activityRepository.findAll();
        return activitiesList;
    }

}
