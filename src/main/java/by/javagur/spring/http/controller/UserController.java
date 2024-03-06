package by.javagur.spring.http.controller;

import by.javagur.spring.database.entity.Role;
import by.javagur.spring.dto.DtoToUser;
import by.javagur.spring.services.impl.CompanyServiceImpl;
import by.javagur.spring.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final CompanyServiceImpl companyService;

    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String create(@ModelAttribute DtoToUser user) {
        var dto = userService.create(user);
        return "redirect:/users/" + dto.getId();
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute DtoToUser user) {
        userService.update(id, user);
        return "redirect:/users/{id}";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") DtoToUser userCreateEditDto) {
        model.addAttribute("user", userCreateEditDto);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

}
