package by.javaguru.integration.service;

import by.javagur.spring.ApplicationRunner;
import by.javagur.spring.config.DatabaseProperties;
import by.javagur.spring.dto.CompanyReadDto;
import by.javagur.spring.service.CompanyService;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
//    private static final Integer COMPANY_ID = 1;
//
//    private final CompanyService companyService;
//    private final DatabaseProperties databaseProperties;
//
//    @Test
//    void findById() {
//        var actualResult = companyService.findById(COMPANY_ID);
//
//        assertTrue(actualResult.isPresent());
//
//        var expectedResult = new CompanyReadDto(COMPANY_ID);
//
//        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
//    }
}
