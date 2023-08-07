package com.Project_2.Attendance_Management_System.dao;

import com.Project_2.Attendance_Management_System.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyDao extends JpaRepository<Faculty,Long> {

    // Define custom query methods to find faculties by subject name
    List<Faculty> findBySubjectName(String subjectName);
}
