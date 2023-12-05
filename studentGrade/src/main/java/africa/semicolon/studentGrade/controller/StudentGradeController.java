package africa.semicolon.studentGrade.controller;

import africa.semicolon.studentGrade.dtos.CreateAccountRequest;
import africa.semicolon.studentGrade.dtos.LoginRequest;
import africa.semicolon.studentGrade.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "studentGradeApp")
public class StudentGradeController {

    @Autowired
    private TeacherService teacherService;
    @PostMapping(path = "api/v1/createAccount")
    public String teacherCreateAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        try {
            teacherService.createAccount(createAccountRequest);
            return "Registration successful";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @PostMapping(path = "api/vi/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            teacherService.setLogin(loginRequest);
            return "Login successful";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @PostMapping(path = "api/vi/logout")
    public String logout() {
        teacherService.setLogout();
        return "See you again!";
    }

    public String collateGrade() {
        return null;
    }
}
