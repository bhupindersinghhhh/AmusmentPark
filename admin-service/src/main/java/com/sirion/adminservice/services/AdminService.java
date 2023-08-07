package com.sirion.adminservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.adminservice.entity.Admin;
import com.sirion.adminservice.exception.IllegalAdminException;
import com.sirion.adminservice.repository.AdminRepository;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin insertAdmin(Admin admin) throws IllegalAdminException {
        Optional<Admin> adminOptional = adminRepository.findById(admin.getAdminId());
        if (!adminOptional.isPresent()) {
            return adminRepository.save(admin);
        } else {
            throw new IllegalAdminException("Admin already exists.");
        }
    }

    @Override
    public Admin updateAdmin(Admin admin) throws IllegalAdminException {
        Optional<Admin> adminOptional = adminRepository.findById(admin.getAdminId());
        if (adminOptional.isPresent()) {
            return adminRepository.save(admin);
        } else {
            throw new IllegalAdminException("Admin does not exist.");
        }
    }

    @Override
    public Admin deleteAdmin(int adminId) throws IllegalAdminException {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            adminRepository.delete(adminOptional.get());
            return adminOptional.get();
        } else {
            throw new IllegalAdminException("Admin does not exist.");
        }
    }

}
