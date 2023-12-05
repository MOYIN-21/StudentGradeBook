package africa.semicolon.studentGrade.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Teacher {

    @Id
    private String id;
    private String username;
    private String password;
    private boolean isLocked;
}
