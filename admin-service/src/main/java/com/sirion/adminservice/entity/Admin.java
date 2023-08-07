package com.sirion.adminservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    public Admin(String username, String password, String mobileNumber, String email) {
        this.setUsername(username);
        this.setPassword(password);
        this.setMobileNumber(mobileNumber);
        this.setEmail(email);
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "[Admin ID=" + this.adminId + ", Username=" + this.getUsername() + "]";
    }
}