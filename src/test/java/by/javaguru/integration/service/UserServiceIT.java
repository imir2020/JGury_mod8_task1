package by.javaguru.integration.service;


import by.javagur.spring.database.entity.Role;
import by.javagur.spring.database.repository.CompanyRepository;
import by.javagur.spring.dto.DtoToUser;
import by.javagur.spring.services.impl.UserServiceImpl;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserServiceImpl userService;
    private final CompanyRepository companyRepository;

    @Test
    void findAll() {
        var list = userService.findAll();
        assertTrue(list.size() > 0);
        assertThat(list).hasSize(5);
    }

    @Test
    void findById() {
        Long id = 1L;
        var user = userService.findById(id);
        assertTrue(user.isPresent());
    }

    @Test
    void findByName() {
        String name = "Kate";
        var user = userService.findByName(name);
    }

    @Test
    void create() {
        Integer id = 3;
        var dtoToUser = DtoToUser.builder()
                .username("s@ff.dd")
                .birthDate(LocalDate.now())
                .firstname("Solomon")
                .lastname("Treid")
                .role(Role.ADMIN)
                .companyId(id)
                .build();
        var result = userService.create(dtoToUser);
        assertNotNull(result);
    }

    @Test
    void update() {
        Integer companyId = 3;
        var dtoToUser = DtoToUser.builder()
                .username("s@ff.dd")
                .birthDate(LocalDate.now())
                .firstname("Solomon")
                .lastname("Treid")
                .role(Role.ADMIN)
                .companyId(companyId)
                .build();
        Long userId = 2L;
        var result = userService.update(userId, dtoToUser);
        assertTrue(result.isPresent());
    }

    @Test
    void delete() {
        Long id = 1L;
        var isDelete = userService.delete(id);
        assertTrue(isDelete);
    }
}