package com.Project_2.Attendance_Management_System.dto;

import com.Project_2.Attendance_Management_System.entities.Faculty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyAddDto {
    private Long facultyId;
    private Long student;
}
