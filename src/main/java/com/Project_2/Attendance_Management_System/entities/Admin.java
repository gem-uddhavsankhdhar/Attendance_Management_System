package com.Project_2.Attendance_Management_System.entities;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="Admin_Details")
@Data
public class Admin {
    @Id
    private Long AdminId;
    private String AdminName;
}
