package com.carcontrol.api.V1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna o nome do template de login
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Retorna o nome do template da página inicial
    }
}