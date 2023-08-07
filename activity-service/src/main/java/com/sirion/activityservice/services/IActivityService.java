package com.sirion.activityservice.services;

import java.util.List;

import com.sirion.activityservice.entity.Activity;
import com.sirion.activityservice.exception.IllegalActivityException;

public interface IActivityService {
	public Activity insertActivity(Activity activity) throws IllegalActivityException;

	public Activity updateActivity(Activity activity) throws IllegalActivityException;

	public Activity deleteActivity(int activityId) throws IllegalActivityException;

	public List<Activity> viewActivitiesOfCharges(double charges);

	public List<Activity> getAllActivities();
}