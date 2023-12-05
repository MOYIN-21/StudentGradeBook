package africa.semicolon.studentGrade.java.utils;

import africa.semicolon.studentGrade.data.models.Student;
import africa.semicolon.studentGrade.dtos.RegisterStudentRequest;

public class Mapper {

    public static Student map(RegisterStudentRequest registerStudent) {
        Student newStudent = new Student();
        newStudent.setFirstName(registerStudent.getFirstName());
        newStudent.setLastName(registerStudent.getLastName());
        newStudent.setStudentMatricNumber(registerStudent.getStudentMatricNumber());
        newStudent.setSubject(registerStudent.getSubject());
        newStudent.setScore(registerStudent.getScore());
        return newStudent;
    }
}
