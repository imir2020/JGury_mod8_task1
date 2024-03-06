package by.javaguru.integration.service;

import by.javagur.spring.services.impl.CompanyServiceImpl;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
public class CompanyServiceIT {

    private final CompanyServiceImpl companyService;

    @Test
    void findById() {
        Integer id = 1;
        var actualResult = companyService.findById(id);
        assertTrue(actualResult.isPresent());
    }

    @Test
    void findAll(){
        var list = companyService.findAll();
        assertTrue(list.size()>0);
        assertThat(list).hasSize(3);
    }
}
