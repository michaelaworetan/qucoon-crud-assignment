package org.example.crudassignment.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCreateRequest {
    private String studentName;
    private String studentEmail;
    private int studentAge;
}
