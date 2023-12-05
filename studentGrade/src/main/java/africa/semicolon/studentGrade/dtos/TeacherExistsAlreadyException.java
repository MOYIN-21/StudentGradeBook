package africa.semicolon.studentGrade.dtos;

public class TeacherExistsAlreadyException extends RuntimeException {
    public TeacherExistsAlreadyException(String message) {
        super(message);
    }
}
