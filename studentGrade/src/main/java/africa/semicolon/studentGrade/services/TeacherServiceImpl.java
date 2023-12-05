//package africa.semicolon.studentGrade.services;
//
//import africa.semicolon.studentGrade.data.models.Teacher;
//import africa.semicolon.studentGrade.data.repositories.TeacherRepository;
//import africa.semicolon.studentGrade.dtos.CreateAccountRequest;
//import africa.semicolon.studentGrade.dtos.TeacherExistsAlreadyException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class TeacherServiceImpl implements TeacherService {
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    @Override
//    public void createAccount(CreateAccountRequest createAccount) {
//        findTeacherByUsername(createAccount);
//        Teacher teacher = new Teacher();
//        teacher.setUsername(createAccount.getUsername());
//        teacher.setPassword(createAccount.getPassword());
////        teacherRepository.save(teacher);
//    }
//
//    private void findTeacherByUsername(CreateAccountRequest createAccount) {
//        Optional<Teacher> teacher = teacherRepository.findTeacherByUsername(createAccount.getUsername());
//        if (teacher.isPresent())
//            throw new TeacherExistsAlreadyException("Teacher exists in the database!");
//    }
//
//    @Override
//    public long count() {
//        return teacherRepository.count();
//    }
//}
