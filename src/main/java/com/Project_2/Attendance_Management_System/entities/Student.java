package com.Project_2.Attendance_Management_System.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name="Student_Details")
@Data
public class Student {
    @Id
    private Long studentId;
    @NotEmpty
    private String studentName;
    @Email(message = "Email address is not valid!")
    @Min(5)
    @Max(35)
    private int studentAge;
    private String studentEmail;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number!")
    private String studentMobileNo;
    @JsonIgnore
    @ElementCollection
    private Map<String, Boolean> attendance = new HashMap<>();

}
