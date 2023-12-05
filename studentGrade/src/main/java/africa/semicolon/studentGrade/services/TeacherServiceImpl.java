package africa.semicolon.studentGrade.services;

import africa.semicolon.studentGrade.data.models.Teacher;
import africa.semicolon.studentGrade.data.repositories.TeacherRepository;
import africa.semicolon.studentGrade.dtos.CreateAccountRequest;
import africa.semicolon.studentGrade.dtos.LoginRequest;
import africa.semicolon.studentGrade.dtos.TeacherExistsAlreadyException;
import africa.semicolon.studentGrade.exceptions.IncorrectUsernameOrPasswordException;
import africa.semicolon.studentGrade.exceptions.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void createAccount(CreateAccountRequest createAccount) {
        findTeacherByUsername(createAccount);
        Teacher teacher = new Teacher();
        teacher.setUsername(createAccount.getUsername());
        teacher.setPassword(createAccount.getPassword());
        teacher.setLocked(true);
        teacherRepository.save(teacher);
    }

    private void findTeacherByUsername(CreateAccountRequest createAccount) {
        Optional<Teacher> teacher = teacherRepository.findTeacherByUsername(createAccount.getUsername());
        if (teacher.isPresent())
            throw new TeacherExistsAlreadyException("Teacher exists in the database!");
    }

    @Override
    public long count() {
        return teacherRepository.count();
    }

    @Override
    public void deleteAll() {
        teacherRepository.deleteAll();
    }

    @Override
    public Teacher setLogin(LoginRequest loginRequest) {
        Optional<Teacher> foundTeacher = teacherRepository.findTeacherByUsername(loginRequest.getUsername());
        if (foundTeacher.isEmpty())
            throw new TeacherNotFoundException("Teacher account not found");
        if (foundTeacher.get().getUsername().equals(loginRequest.getUsername())
                && foundTeacher.get().getPassword().equals(loginRequest.getPassword()))
            foundTeacher.get().setLocked(false);
        else throw new IncorrectUsernameOrPasswordException("Username or password incorrect");
        teacherRepository.save(foundTeacher.get());
        return foundTeacher.get();
    }

    @Override
    public Teacher setLogout() {
        Teacher teacher = new Teacher();
        teacher.setLocked(true);
        return teacher;
    }
}
