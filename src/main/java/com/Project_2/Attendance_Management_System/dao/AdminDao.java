package com.Project_2.Attendance_Management_System.dao;

import com.Project_2.Attendance_Management_System.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Long> {
}
