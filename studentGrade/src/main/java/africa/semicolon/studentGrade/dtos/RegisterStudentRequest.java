package africa.semicolon.studentGrade.dtos;

import africa.semicolon.studentGrade.data.models.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class RegisterStudentRequest {

    private String firstName;
    private String lastName;
    private String studentMatriculationNumber;
    private List<Subject> subject = new ArrayList<>();
    private double score;
    private String grade;

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }
}
