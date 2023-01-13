package com.april2nd.emailcertapi.controller;

import javax.servlet.http.HttpServletRequest;

import com.april2nd.emailcertapi.model.UserDto;
import com.april2nd.emailcertapi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("userDto") UserDto userDto) {
        userService.insert(userDto);
        return "redirect:/login";
    }
}