package org.example.crudassignment.repository.implementation;

import org.example.crudassignment.mapper.StudentRowMapper;
import org.example.crudassignment.model.entity.Student;
import org.example.crudassignment.repository.Interface.StudentRepository;
import org.example.crudassignment.repository.query.StudentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        return jdbcTemplate.query(StudentQuery.GET_ALL, new StudentRowMapper());
    }

    @Override
    public Student getStudentById(int studentId) {
        MapSqlParameterSource params = new MapSqlParameterSource("studentId", studentId);
        return jdbcTemplate.queryForObject(StudentQuery.GET_BY_ID, params, new StudentRowMapper());
    }

    @Override
    public int createStudent(Student student) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("studentName", student.getStudentName())
                .addValue("studentEmail", student.getStudentEmail())
                .addValue("studentAge", student.getStudentAge());
        return jdbcTemplate.update(StudentQuery.INSERT_STUDENT, params);
    }

    @Override
    public int updateStudent(Student student) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("studentId", student.getStudentId())
                .addValue("studentName", student.getStudentName())
                .addValue("studentEmail", student.getStudentEmail())
                .addValue("studentAge", student.getStudentAge());
        return jdbcTemplate.update(StudentQuery.UPDATE_STUDENT, params);
    }

    @Override
    public int deleteStudent(int studentId) {
        MapSqlParameterSource params = new MapSqlParameterSource("studentId", studentId);
        return jdbcTemplate.update(StudentQuery.DELETE_STUDENT, params);
    }
}
