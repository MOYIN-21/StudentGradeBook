package africa.semicolon.studentGrade.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class Student {
    @Id
    private String id;
    private String name;
    private int grade;


}
