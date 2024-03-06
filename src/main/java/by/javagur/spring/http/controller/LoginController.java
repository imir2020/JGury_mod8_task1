package by.javagur.spring.http.controller;

import by.javagur.spring.database.entity.Role;
import by.javagur.spring.dto.LoginDto;
import by.javagur.spring.services.impl.CompanyServiceImpl;
import by.javagur.spring.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserServiceImpl userService;
    private final CompanyServiceImpl companyService;

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("login") LoginDto loginDto) {
        var result = userService.findByName(loginDto.getUsername());
        model.addAttribute("user",result);
        model.addAttribute("roles", Role.values());
        if (result.get().getRole() == Role.USER) {
            return "redirect:/users/" + result.get().getId();
        } else {
            return "redirect:/users/users";
        }
    }
}
