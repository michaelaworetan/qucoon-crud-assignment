package org.example.crudassignment.controller;

import org.example.crudassignment.Service.StudentService;
import org.example.crudassignment.model.entity.Student;
import org.example.crudassignment.model.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint to create a student
    @PostMapping("/create-student")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateRequest request) {
        var resp = studentService.createStudent(request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student creation failed");
        }
        return ResponseEntity.ok("Student created successfully");
    }

    // Endpoint to get all students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Endpoint to get student by ID
    @GetMapping("/get-by-id/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if student not found
        }
        return ResponseEntity.ok(student);
    }

    // Endpoint to update student by ID
    @PutMapping("/update-student/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable int studentId, @RequestBody StudentCreateRequest request) {
        var resp = studentService.updateStudent(studentId, request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found or update failed");
        }
        return ResponseEntity.ok("Student updated successfully");
    }

    // Endpoint to delete student by ID
    @DeleteMapping("/delete-student/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        var resp = studentService.deleteStudent(studentId);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found or deletion failed");
        }
        return ResponseEntity.ok("Student deleted successfully");
    }
}
