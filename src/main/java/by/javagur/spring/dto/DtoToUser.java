package by.javagur.spring.dto;

import by.javagur.spring.database.entity.Role;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;


@Value
@Builder
@FieldNameConstants
public class DtoToUser {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
