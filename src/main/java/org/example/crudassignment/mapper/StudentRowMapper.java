package org.example.crudassignment.mapper;

import org.example.crudassignment.model.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Student.builder()
                .studentId(rs.getInt("studentId"))
                .studentName(rs.getString("studentName"))
                .studentEmail(rs.getString("studentEmail"))
                .studentAge(rs.getInt("studentAge"))
                .studentCreatedAt(rs.getString("studentCreatedAt"))
                .studentUpdatedAt(rs.getString("studentUpdatedAt"))
                .build();
    }
}
