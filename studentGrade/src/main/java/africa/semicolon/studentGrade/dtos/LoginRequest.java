package africa.semicolon.studentGrade.dtos;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
    private boolean isLocked;
}
