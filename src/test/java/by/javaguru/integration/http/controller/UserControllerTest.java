package by.javaguru.integration.http.controller;

import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerTest {

    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", hasSize(5)));
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/users/{id}", 2))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/user"))
                .andExpect(model().attributeExists("user", "roles", "companies"));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                        .param("username", "svet@gmail.com")
                        .param("firstname", "FirstName")
                        .param("lastname", "LastName")
                        .param("role", "ADMIN")
                        .param("companyId", "1"))
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/users/*"));
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(post("/users/2/update")
                        .param("username", "svt@gmail.com")
                        .param("firstname", "FirstName")
                        .param("lastname", "LastName")
                        .param("role", "USER")
                        .param("companyId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/2"));
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(post("/users/4/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"));
    }

    @Test
    void registration() throws Exception {
        var s = mockMvc.perform(get("/users/registration")
                        .param("username", "svtio@gml.cm")
                        .param("firstname", "WorstName")
                        .param("lastname", "LastName")
                        .param("role", "USER")
                        .param("companyId", "2"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/registration"))
                .andExpect(model().attributeExists("user", "roles", "companies"));

    }

}
