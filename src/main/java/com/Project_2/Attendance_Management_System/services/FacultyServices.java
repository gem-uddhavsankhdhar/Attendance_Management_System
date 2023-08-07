package com.Project_2.Attendance_Management_System.services;

import com.Project_2.Attendance_Management_System.dao.FacultyDao;
import com.Project_2.Attendance_Management_System.dto.FacultyAddDto;
import com.Project_2.Attendance_Management_System.entities.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServices {
    @Autowired
    public FacultyDao facultyDao;

    public Faculty createFaculty(Faculty faculty) {
        facultyDao.save(faculty);
        return faculty;
    }

    public List<Faculty> getAllFaculty() {
        List<Faculty> facultyList = new ArrayList<>();
        facultyDao.findAll().forEach(facultyList::add);
        return facultyList;
    }

    public Faculty facultyDetails(Long facultyId) {
        Faculty faculty = facultyDao.findById(facultyId).orElse(null);
            return faculty;
    }

    public Faculty deleteFaculty(Long facultyId) {
        Faculty faculty = facultyDao.findById(facultyId).orElse(null);
        facultyDao.deleteById(facultyId);
        if(faculty!=null){
            return faculty;
        }
        else{
            return null;
        }
    }

    public Faculty updateFacultyDetails(Long facultyId, Faculty updatedFaculty) {
        Faculty faculty = facultyDao.findById(facultyId).orElse(null);
        if(faculty!=null) {
            return facultyDao.save(updatedFaculty);
        }
        else {
            return null;
        }
    }


}
