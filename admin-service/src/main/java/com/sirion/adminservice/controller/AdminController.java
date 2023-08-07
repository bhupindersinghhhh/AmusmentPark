package com.sirion.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.adminservice.entity.Admin;
import com.sirion.adminservice.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin, HttpServletRequest request) {
        if (admin != null) {
            try {
                adminService.insertAdmin(admin);
                return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Admin>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        if (admin != null) {
            try {
                adminService.updateAdmin(admin);
                return new ResponseEntity<Admin>(admin, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Admin>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "delete/id/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") int adminId) {
        try {
            Admin admin = adminService.deleteAdmin(adminId);
            return new ResponseEntity<Admin>(admin, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Admin>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
