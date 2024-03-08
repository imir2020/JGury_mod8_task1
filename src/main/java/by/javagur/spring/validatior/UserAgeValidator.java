package by.javagur.spring.validatior;

import by.javagur.spring.dto.DtoToUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;


@Component
public class UserAgeValidator implements ConstraintValidator<Age, DtoToUser> {

    @Override
    public boolean isValid(DtoToUser value, ConstraintValidatorContext context) {
        if (value.getBirthDate() == null) {
            return false;
        }
        return (Period.between(value.getBirthDate(), LocalDate.now()).getYears()) >= 18 ? true : false;
    }

}
