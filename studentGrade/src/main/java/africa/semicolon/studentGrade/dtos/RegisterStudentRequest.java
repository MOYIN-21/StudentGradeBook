package africa.semicolon.studentGrade.dtos;

import africa.semicolon.studentGrade.data.models.Subject;
import lombok.Data;

@Data
public class RegisterStudentRequest {

    private String firstName;
    private String lastName;
    private String studentMatricNumber;
    private Subject subject;
    private int score;
    private String grade;
}
