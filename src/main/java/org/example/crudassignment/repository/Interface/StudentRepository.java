package org.example.crudassignment.repository.Interface;

import org.example.crudassignment.model.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> getAllStudents();

    Student getStudentById(int studentId);  // Return Student directly

    int createStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int studentId);

}
