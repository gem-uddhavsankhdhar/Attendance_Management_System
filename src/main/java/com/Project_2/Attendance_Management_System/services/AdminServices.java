package com.Project_2.Attendance_Management_System.services;

import com.Project_2.Attendance_Management_System.dao.AdminDao;
import com.Project_2.Attendance_Management_System.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {
    @Autowired
    private AdminDao admindao;

    public Admin createAdmin(Admin admin) {
        admindao.save(admin);
        return admin;
    }
}
