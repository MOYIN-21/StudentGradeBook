package africa.semicolon.studentGrade.services;

import africa.semicolon.studentGrade.data.models.Teacher;
import africa.semicolon.studentGrade.dtos.CreateAccountRequest;
import africa.semicolon.studentGrade.dtos.LoginRequest;

public interface TeacherService {

    void createAccount(CreateAccountRequest createAccount);

    long count();

    void deleteAll();

    Teacher setLogin(LoginRequest loginRequest);

    Teacher setLogout();
}
