package africa.semicolon.studentGrade.dtos;

import lombok.Data;

@Data
public class CreateAccountRequest {

    private String username;
    private String password;
}
