package by.javagur.spring.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoginDto {
    String username;
    String password;
}
