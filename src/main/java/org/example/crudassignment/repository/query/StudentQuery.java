package org.example.crudassignment.repository.query;

public class StudentQuery {

    public static final String INSERT_STUDENT = """
        INSERT INTO Student (studentName, studentEmail, studentAge, studentCreatedAt, studentUpdatedAt)
        VALUES (:studentName, :studentEmail, :studentAge, GETDATE(), GETDATE())
    """;

    public static final String GET_ALL = """
        SELECT * FROM Student
    """;

    public static final String GET_BY_ID = """
        SELECT * FROM Student WHERE studentId = :studentId
    """;

    public static final String UPDATE_STUDENT = """
        UPDATE Student
        SET studentName = :studentName, studentEmail = :studentEmail, studentAge = :studentAge, studentUpdatedAt = GETDATE()
        WHERE studentId = :studentId
    """;

    public static final String DELETE_STUDENT = """
        DELETE FROM Student WHERE studentId = :studentId
    """;
}
