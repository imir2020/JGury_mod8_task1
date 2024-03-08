package by.javagur.spring.validatior;

import by.javagur.spring.database.repository.CompanyRepository;
import by.javagur.spring.dto.DtoToUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.hasText;

@Component
public class UserInfoValidator implements ConstraintValidator<UserInfo, DtoToUser> {

    @Override
    public boolean isValid(DtoToUser value, ConstraintValidatorContext context) {
        return hasText(value.getFirstname()) || hasText(value.getLastname());
    }
}