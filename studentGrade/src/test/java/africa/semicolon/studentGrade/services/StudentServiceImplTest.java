package africa.semicolon.studentGrade.services;

import africa.semicolon.studentGrade.data.models.Subject;
import africa.semicolon.studentGrade.data.repositories.StudentRepository;
import africa.semicolon.studentGrade.dtos.RegisterStudentRequest;
import africa.semicolon.studentGrade.exceptions.StudentAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setup() {
        studentRepository.deleteAll();
    }

    @Autowired
    private StudentService studentService;

    @Test
    public void testStudentCanRegister() {
        RegisterStudentRequest newStudent = new RegisterStudentRequest();
        newStudent.setFirstName("Joe");
        newStudent.setLastName("Nath");
        newStudent.setStudentMatricNumber("2023/001");
        newStudent.setSubject(Subject.ECONOMICS);
        newStudent.setScore(90);
        newStudent.setSubject(Subject.BIOLOGY);
        newStudent.setScore(92);
        newStudent.setSubject(Subject.AGRICULTURE);
        newStudent.setScore(78);
        studentService.collateStudentGrade(newStudent);
        assertThat(studentRepository.count(), is(1L));
    }

    @Test
    public void testThatMatricNumberIsUnique() {
        RegisterStudentRequest newStudent = new RegisterStudentRequest();
        newStudent.setFirstName("Joe");
        newStudent.setLastName("Nath");
        newStudent.setStudentMatricNumber("2023/001");
        studentService.collateStudentGrade(newStudent);
        assertThat(studentRepository.count(), is(1L));

        RegisterStudentRequest newStudent2 = new RegisterStudentRequest();
        newStudent2.setFirstName("Joe");
        newStudent2.setLastName("Nath");
        newStudent2.setStudentMatricNumber("2023/001");
        assertThrows(StudentAlreadyExistsException.class, ()-> studentService.collateStudentGrade(newStudent2));
    }
}