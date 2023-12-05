package africa.semicolon.studentGrade.dtos;

import africa.semicolon.studentGrade.data.models.Subject;
import africa.semicolon.studentGrade.exceptions.ScoreOutOfRangeException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AddStudentScoreRequest {

    @Setter
    private String firstName;
    @Setter
    private String lastName;
    private int score;
    @Setter
    private String grade;
    @Setter
    private Subject subject;

    public void setScore(int score) {
        boolean isCorrectScore = score >= 0 && score <= 100;
        if (!isCorrectScore)
            throw new ScoreOutOfRangeException("This score is out of range");
    }
}
