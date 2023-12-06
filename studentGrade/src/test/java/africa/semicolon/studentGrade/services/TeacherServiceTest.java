package africa.semicolon.studentGrade.services;

import africa.semicolon.studentGrade.data.models.Subject;
import africa.semicolon.studentGrade.data.models.Teacher;
import africa.semicolon.studentGrade.dtos.AddStudentScoreRequest;
import africa.semicolon.studentGrade.dtos.CreateAccountRequest;
import africa.semicolon.studentGrade.dtos.LoginRequest;
import africa.semicolon.studentGrade.dtos.RegisterStudentRequest;
import africa.semicolon.studentGrade.exceptions.IncorrectUsernameOrPasswordException;
import africa.semicolon.studentGrade.exceptions.TeacherNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @BeforeEach
    public void setup() {
        teacherService.deleteAll();
    }

    @Test
    public void testThatTeacherCanCreateAccount() {
        CreateAccountRequest createAccount = new CreateAccountRequest();
        createAccount.setUsername("username");
        createAccount.setPassword("password");
        teacherService.createAccount(createAccount);
        assertThat(teacherService.count(), is(1L));
    }

    @Test
    public void testThatTeacherCanLogIn() {
        CreateAccountRequest createAccount = new CreateAccountRequest();
        createAccount.setUsername("username");
        createAccount.setPassword("password");
        teacherService.createAccount(createAccount);
        assertThat(teacherService.count(), is(1L));

        LoginRequest login = new LoginRequest();
        login.setUsername("username");
        login.setPassword("password");
        Teacher teacher = teacherService.setLogin(login);
        assertFalse(teacher.isLocked());
    }

    @Test
    public void testThatTeacherCanLogOut() {
        CreateAccountRequest createAccount = new CreateAccountRequest();
        createAccount.setUsername("username");
        createAccount.setPassword("password");
        teacherService.createAccount(createAccount);
        assertThat(teacherService.count(), is(1L));

        LoginRequest login = new LoginRequest();
        login.setUsername("username");
        login.setPassword("password");
        Teacher teacher = teacherService.setLogin(login);
        assertFalse(teacher.isLocked());

        Teacher newTeacher = teacherService.setLogout();
        assertTrue(newTeacher.isLocked());
    }

    @Test
    public void testThatExceptionIsThrownIfUsernameIsIncorrect() {
        CreateAccountRequest createAccount = new CreateAccountRequest();
        createAccount.setUsername("username");
        createAccount.setPassword("password");
        teacherService.createAccount(createAccount);
        assertThat(teacherService.count(), is(1L));

        LoginRequest login = new LoginRequest();
        login.setUsername("usernames");
        login.setPassword("password");
        assertThrows(TeacherNotFoundException.class, ()-> teacherService.setLogin(login));
    }

}