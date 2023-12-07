package africa.semicolon.studentGrade.exceptions;

public class IncorrectUsernameOrPasswordException extends RuntimeException {
    public IncorrectUsernameOrPasswordException(String message) {
        super(message);
    }
}
