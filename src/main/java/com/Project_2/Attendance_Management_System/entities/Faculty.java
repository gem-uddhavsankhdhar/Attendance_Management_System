package com.Project_2.Attendance_Management_System.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;


@Entity
@Table(name = "Faculty_Details")
@Data
public class Faculty {
    @Id
    private Long facultyId;
    @NotEmpty
    @Size(min=4, message="Name must be a min of 4 characters!")
    private String facultyName;
    @NotEmpty
    private String subjectName;
    @Email(message = "Email address is not valid!")
    private String facultyEmail;
    @Min(18)
    @Max(60)
    private int facultyAge;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number!")
    private String facultyMobileNo;
}
