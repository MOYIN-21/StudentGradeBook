package africa.semicolon.studentGrade.services;

import africa.semicolon.studentGrade.data.models.Student;
import africa.semicolon.studentGrade.data.models.Subject;
import africa.semicolon.studentGrade.data.repositories.StudentRepository;
import africa.semicolon.studentGrade.dtos.RegisterStudentRequest;
import africa.semicolon.studentGrade.exceptions.StudentAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.studentGrade.java.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void collateStudentGrade(RegisterStudentRequest registerStudent) {
        findStudentByMatricNumber(registerStudent);
        Student newStudent = map(registerStudent);
        studentRepository.save(newStudent);
    }

    private void findStudentByMatricNumber(RegisterStudentRequest registerStudent) {
        Optional<Student> student = studentRepository.findStudentByStudentMatricNumber(registerStudent.getStudentMatricNumber());
        if (student.isPresent())
            throw new StudentAlreadyExistsException("Student exists already");
    }

}
