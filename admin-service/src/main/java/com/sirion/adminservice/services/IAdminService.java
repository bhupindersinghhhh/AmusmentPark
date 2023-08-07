package com.sirion.adminservice.services;

import com.sirion.adminservice.entity.Admin;
import com.sirion.adminservice.exception.IllegalAdminException;

public interface IAdminService {
    public Admin insertAdmin(Admin admin) throws IllegalAdminException;

    public Admin updateAdmin(Admin admin) throws IllegalAdminException;

    public Admin deleteAdmin(int adminId) throws IllegalAdminException;

    // public List<Activity> getAllActivities();
}
