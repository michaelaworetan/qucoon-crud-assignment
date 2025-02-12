package org.example.crudassignment.model.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private int studentId;
    private String studentName;
    private String studentEmail;
    private int studentAge;
    private String studentCreatedAt;
    private String studentUpdatedAt;
}
