package com.Project_2.Attendance_Management_System.services;

import com.Project_2.Attendance_Management_System.dao.FacultyDao;
import com.Project_2.Attendance_Management_System.dao.StudentDao;
import com.Project_2.Attendance_Management_System.entities.Faculty;
import com.Project_2.Attendance_Management_System.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentServices {
    @Autowired
    public StudentDao studentDao;

    @Autowired
    public FacultyDao facultyDao;

    public Student createStudent(Student student) {
        studentDao.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList=new ArrayList<>();
        studentDao.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student studentDetails(Long studentId) {
        Student student = studentDao.findById(studentId).orElse(null);
            return student;
    }

    public boolean deleteStudent(Long studentId) {
        Student student = studentDao.findById(studentId).orElse(null);

        if(student!=null){
            studentDao.deleteById(studentId);
            return true;
        }
        else{
            return false;
        }
    }

    public Student updateStudentDetails(Long studentId, Student updatedStudent) {
        Student student = studentDao.findById(studentId).orElse(null);
        if(student!=null) {
            return studentDao.save(updatedStudent);
        }
        else {
            return null;
        }
    }

    public boolean markAttendance(Long studentId, boolean isPresent){
        Student student = studentDao.findById(studentId).orElse(null);
        if(student!=null) {
            String today = LocalDate.now().toString();
            Map<String, Boolean> attendance = student.getAttendance();
            attendance.put(today, isPresent);
            studentDao.save(student);
            return true;
        }
        else {
            return false;
        }
    }

    public List<String> getFacultyNamesBySubject(String subjectName) {
    List<Faculty> faculties = facultyDao.findBySubjectName(subjectName);
    if(faculties == null || faculties.isEmpty()){
        return null;
    }
    List<String> facultyNames = new ArrayList<>();
    for(Faculty faculty : faculties){
        facultyNames.add(faculty.getFacultyName());
    }
    return facultyNames;
    }
}
