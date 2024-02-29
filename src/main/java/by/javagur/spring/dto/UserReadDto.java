package by.javagur.spring.dto;

import by.javagur.spring.database.entity.Company;
import by.javagur.spring.database.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    CompanyReadDto company;
}
