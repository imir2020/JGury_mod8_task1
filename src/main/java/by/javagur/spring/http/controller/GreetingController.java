package by.javagur.spring.http.controller;

import by.javagur.spring.database.entity.Role;
import by.javagur.spring.database.repository.CompanyRepository;
import by.javagur.spring.dto.UserReadDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/api/v1")
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello/{id}")
    public String hello(@RequestParam Integer age,
                        @RequestHeader String accept,
                        @CookieValue("JSESSIONID") String jsessionId,
                        @PathVariable("id") Integer id,
                        Model model,
                        UserReadDto userReadDto) {
        model.addAttribute("user", userReadDto);
        return "greeting/hello";
    }

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {
        return "greeting/bye";
    }
}
