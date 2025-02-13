package org.example.crudassignment.Service;

import com.google.gson.Gson;
import org.example.crudassignment.model.entity.Student;
import org.example.crudassignment.model.request.StudentCreateRequest;
import org.example.crudassignment.repository.Interface.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    // Get student by ID
    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    // Create a new student
    public int createStudent(StudentCreateRequest request) {
        Gson gson = new Gson();
        // Converts CreateRequest to Student entity
        var student = gson.fromJson(gson.toJson(request), Student.class);
        return studentRepository.createStudent(student);
    }

    // Update an existing student
    public int updateStudent(int studentId, StudentCreateRequest request) {
        // First, check if the student exists
        Student existingStudent = studentRepository.getStudentById(studentId);
        if (existingStudent != null) {
            // Map the update request fields to the existing student
            existingStudent.setStudentName(request.getStudentName());
            existingStudent.setStudentEmail(request.getStudentEmail());
            existingStudent.setStudentAge(request.getStudentAge());
            existingStudent.setStudentUpdatedAt("GETDATE()");
            // Perform the update operation
            return studentRepository.updateStudent(existingStudent);
        }
        return 0; // Return 0 if student not found
    }

    // Delete student by ID
    public int deleteStudent(int studentId) {
        return studentRepository.deleteStudent(studentId);
    }
}
