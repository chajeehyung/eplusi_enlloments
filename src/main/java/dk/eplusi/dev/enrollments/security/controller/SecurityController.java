package dk.eplusi.dev.enrollments.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String login() {
        return "security/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "security/logout";
    }
}