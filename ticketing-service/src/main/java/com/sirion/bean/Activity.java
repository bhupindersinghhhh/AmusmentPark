package com.sirion.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Activity {
	@Id
    private int activityId;
    private String description;
    private double charges;

    public Activity() {
    }

    public Activity(int activityId, String description, double charges) {
        this.activityId = activityId;
        this.description = description;
        this.charges = charges;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "[Activity ID=" + this.activityId + ", Description=" + this.description + ", Charges=" + this.charges
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Activity other = (Activity) obj;
        if (this.activityId != other.activityId)
            return false;
        return true;
    }
}