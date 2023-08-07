package com.Project_2.Attendance_Management_System.controller;

import com.Project_2.Attendance_Management_System.entities.Student;
import com.Project_2.Attendance_Management_System.services.FacultyServices;
import com.Project_2.Attendance_Management_System.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    public StudentServices studentServices;

    //Similar to the one in AdminController but for Faculty with a little different endpoint
    @GetMapping("/GetAllStudentsList")
    @PreAuthorize("hasAuthority('ROLE_FACULTY')")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> newStudentList=studentServices.getAllStudents();
        return ResponseEntity.ok(newStudentList);
    }

    //Similar to the one in AdminController but for Faculty with a little different endpoint
    @PutMapping("/UpdateStudent'sDetails/{studentId}")
    @PreAuthorize("hasAuthority('ROLE_FACULTY')")
    public Student updateStudentDetails(@PathVariable Long studentId, @RequestBody Student updatedStudent){
        return studentServices.updateStudentDetails(studentId, updatedStudent);
    }

    @PostMapping("/MarkAttendance/{studentId}/{isPresent}")
    @PreAuthorize("hasAuthority('ROLE_FACULTY')")
    public ResponseEntity<String> markAttendance(@PathVariable Long studentId, @PathVariable boolean isPresent)
    {
        boolean marked = studentServices.markAttendance(studentId,isPresent);
        if(marked){
            return ResponseEntity.ok("Attendance marked successfully");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
