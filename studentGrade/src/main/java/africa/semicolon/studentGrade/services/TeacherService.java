package africa.semicolon.studentGrade.services;

import africa.semicolon.studentGrade.dtos.CreateAccountRequest;

public interface TeacherService {

    void createAccount(CreateAccountRequest createAccount);

    long count();
}
