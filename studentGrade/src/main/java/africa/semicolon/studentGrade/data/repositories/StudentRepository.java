package africa.semicolon.studentGrade.data.repositories;

import africa.semicolon.studentGrade.data.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByStudentMatricNumber(String studentMatricNumber);
}
