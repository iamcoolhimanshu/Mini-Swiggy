package com.codeWithHimanshu.Swiggy.controller;

import com.codeWithHimanshu.Swiggy.entity.User;
import com.codeWithHimanshu.Swiggy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.register(user);
        return "redirect:/login?success";
    }

}
