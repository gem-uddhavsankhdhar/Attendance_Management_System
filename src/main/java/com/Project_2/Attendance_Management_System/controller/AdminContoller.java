package com.Project_2.Attendance_Management_System.controller;


import com.Project_2.Attendance_Management_System.entities.Admin;
import com.Project_2.Attendance_Management_System.entities.Faculty;
import com.Project_2.Attendance_Management_System.entities.Student;
import com.Project_2.Attendance_Management_System.services.AdminServices;
import com.Project_2.Attendance_Management_System.services.FacultyServices;
import com.Project_2.Attendance_Management_System.services.StudentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminContoller {

    Logger logger = LoggerFactory.getLogger(AdminContoller.class);
    @Autowired
    public AdminServices adminServices;
    @Autowired
    public FacultyServices facultyServices;

    @Autowired
    public StudentServices studentServices;

    @PostMapping("/CreateAdmin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin){
        logger.info("Creating Admin: {}", admin);
        Admin newAdmin = adminServices.createAdmin(admin);
        return ResponseEntity.ok(newAdmin);
    }
    @PostMapping("/CreateFaculty")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Faculty> createFaculty(@Valid @RequestBody Faculty faculty){
        logger.info("Creating Faculty: {}", faculty);
        Faculty newFaculty=facultyServices.createFaculty(faculty);
        return ResponseEntity.ok(newFaculty);
    }
    @PostMapping("/CreateStudent")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student){
        logger.info("Creating Student: {}", student);
        Student newStudent=studentServices.createStudent(student);
        return ResponseEntity.ok(newStudent);
    }
    @GetMapping("/GetAllFaculty")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        List<Faculty> newFacultyList=facultyServices.getAllFaculty();
        return ResponseEntity.ok(newFacultyList);
    }
    @GetMapping("/GetAllStudents")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> newStudentList=studentServices.getAllStudents();
        return ResponseEntity.ok(newStudentList);
    }
    @GetMapping("/GetFacultyById/{facultyId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Faculty facultyDetails(@PathVariable("facultyId") Long facultyId){
        Faculty faculty = facultyServices.facultyDetails(facultyId);
        return faculty;
    }
    @GetMapping("/GetStudentById/{studentId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Student studentDetails(@PathVariable("studentId") Long studentId){
        Student student = studentServices.studentDetails(studentId);
        return student;
    }
    @PutMapping("/UpdateFacultyDetails/{facultyId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Faculty updateFacultyDetails(@Valid @PathVariable Long facultyId, @RequestBody Faculty updatedFaculty){
        return facultyServices.updateFacultyDetails(facultyId, updatedFaculty);
    }

    @PutMapping("/UpdateStudentDetails/{studentId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Student updateStudentDetails(@Valid @PathVariable Long studentId, @RequestBody Student updatedStudent){
        return studentServices.updateStudentDetails(studentId, updatedStudent);
    }


    @DeleteMapping("/DeleteFaculty/{facultyId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyServices.deleteFaculty(facultyId);
        if(faculty!=null){
            return ResponseEntity.ok("Faculty deleted successfully");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteStudent/{studentId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        boolean student = studentServices.deleteStudent(studentId);
        if(student){
            return ResponseEntity.ok("Student deleted successfully");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

