package africa.semicolon.studentGrade.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String studentMatricNumber;
    private Subject subject;
    private double score;
    private String grade;

    public void setScore(double score) {
        if (score > 80)
            this.grade = "A";
        if (score > 70 && score <= 80)
            this.grade = "B";
        if (score > 60 && score <= 70)
            this.grade = "C";
        if (score > 50 && score <= 60)
            this.grade = "D";
        if (score > 40 && score <= 50)
            this.grade = "E";
        else if (score <= 40)
            this.grade = "F";
        this.score = score;
    }

    @Override
    public String toString() {
        return  "FullName: " + firstName + " " + lastName +
                "Subject: " + subject +
                "Score: " + score +
                '}';
    }
}
