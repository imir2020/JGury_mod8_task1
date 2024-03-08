package by.javagur.spring.dto;

import by.javagur.spring.database.entity.Role;
import by.javagur.spring.validatior.Age;
import by.javagur.spring.validatior.UserInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;


@Value
@Builder
@FieldNameConstants
@UserInfo
@Age
public class DtoToUser {
    @Email
    String username;
    LocalDate birthDate;

    @Size(min = 3, max = 30)
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
