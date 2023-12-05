//package africa.semicolon.studentGrade.services;
//
//import africa.semicolon.studentGrade.data.models.Subject;
//import africa.semicolon.studentGrade.data.repositories.TeacherRepository;
//import africa.semicolon.studentGrade.dtos.AddStudentScoreRequest;
//import africa.semicolon.studentGrade.dtos.CreateAccountRequest;
//import africa.semicolon.studentGrade.dtos.RegisterStudentRequest;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class TeacherServiceTest {
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @Test
//    public void testThatTeacherCanCreateAccount() {
//        CreateAccountRequest createAccount = new CreateAccountRequest();
//        createAccount.setUsername("username");
//        createAccount.setPassword("password");
//        teacherService.createAccount(createAccount);
//        assertThat(teacherService.count(), is(1L));
//    }
//}