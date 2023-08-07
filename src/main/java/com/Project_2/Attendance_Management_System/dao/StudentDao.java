package com.Project_2.Attendance_Management_System.dao;

import com.Project_2.Attendance_Management_System.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Long> {
}
