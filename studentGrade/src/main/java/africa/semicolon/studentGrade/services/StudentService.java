package africa.semicolon.studentGrade.services;


import africa.semicolon.studentGrade.dtos.RegisterStudentRequest;

public interface StudentService {

    void collateStudentGrade(RegisterStudentRequest newStudent);
}
