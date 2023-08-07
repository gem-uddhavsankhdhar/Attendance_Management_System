package com.Project_2.Attendance_Management_System.controller;

import com.Project_2.Attendance_Management_System.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentServices studentServices;


    @GetMapping("/GetFacultyNamesBySubject/{subjectName}")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public ResponseEntity<List<String>> getFacultyNamesBySubject(@PathVariable String subjectName){
        List<String> facultyNames = studentServices.getFacultyNamesBySubject(subjectName);
        if(facultyNames != null && !facultyNames.isEmpty()){
            return ResponseEntity.ok(facultyNames);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
