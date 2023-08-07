package com.sirion.activityservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.activityservice.entity.Activity;
import com.sirion.activityservice.services.ActivityService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping(value = "/add")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity, HttpServletRequest request) {
        if (activity != null) {
            try {
                activityService.insertActivity(activity);
                return new ResponseEntity<Activity>(activity, HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Activity>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Activity>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        if (!activities.isEmpty()) {
            return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
        }
        return new ResponseEntity<List<Activity>>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity) {
        if (activity != null) {
            try {
                activityService.updateActivity(activity);
                return new ResponseEntity<Activity>(activity, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Activity>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Activity>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "delete/id/{id}")
    public ResponseEntity<Activity> deleteActivity(@PathVariable("id") int activityId) {
        try {
            Activity activity = activityService.deleteActivity(activityId);
            return new ResponseEntity<Activity>(activity, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Activity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all/charges/{charges}")
    public ResponseEntity<List<Activity>> viewActivitiesOfCharges(@PathVariable("charges") double charges) {
        List<Activity> activities = activityService.viewActivitiesOfCharges((double) charges);
        System.out.println(charges);
        if (!activities.isEmpty()) {
            return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
        }
        return new ResponseEntity<List<Activity>>(HttpStatus.NOT_FOUND);
    }

}
