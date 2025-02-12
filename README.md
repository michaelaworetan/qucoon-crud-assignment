# CRUD Assignment

This is a simple CRUD (Create, Read, Update, Delete) application for managing wallets and students. The project is built using Java, Spring Boot, and Gradle.

## Project Structure

- `src/main/java/org/example/crudassignment/controller/WalletController.java`: Handles HTTP requests for wallet operations.
- `src/main/java/org/example/crudassignment/controller/StudentController.java`: Handles HTTP requests for student operations.
- `src/main/java/org/example/crudassignment/service/WalletService.java`: Contains business logic for wallet operations.
- `src/main/java/org/example/crudassignment/service/StudentService.java`: Contains business logic for student operations.
- `src/main/java/org/example/crudassignment/repository/implementation/WalletRepositoryImpl.java`: Implements data access methods for wallets.
- `src/main/java/org/example/crudassignment/repository/implementation/StudentRepositoryImpl.java`: Implements data access methods for students.
- `src/main/java/org/example/crudassignment/mapper/WalletRowMapper.java`: Maps SQL result sets to Wallet objects.
- `src/main/java/org/example/crudassignment/mapper/StudentRowMapper.java`: Maps SQL result sets to Student objects.
- `src/main/java/org/example/crudassignment/model/entity/Wallet.java`: Represents the Wallet entity.
- `src/main/java/org/example/crudassignment/model/entity/Student.java`: Represents the Student entity.
- `src/main/java/org/example/crudassignment/model/request/WalletCreateRequest.java`: Represents the request payload for creating or updating a wallet.
- `src/main/java/org/example/crudassignment/model/request/StudentCreateRequest.java`: Represents the request payload for creating or updating a student.

## Prerequisites

- Java 11 or higher
- Gradle
- A running instance of a database (e.g., MySQL, PostgreSQL)

## Getting Started

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/crud-assignment.git
   cd crud-assignment
