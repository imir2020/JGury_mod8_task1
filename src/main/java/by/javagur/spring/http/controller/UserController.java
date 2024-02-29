package by.javagur.spring.http.controller;

import by.javagur.spring.dto.UserCreateEditDto;
import by.javagur.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/user";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user) {
        userService.create(user);
        return "redirect:/users/" + 25;
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto user) {
        userService.update(id, user);
        return "redirect:/users/{id}";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
