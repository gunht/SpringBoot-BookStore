package com.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex() {
        return "/shop/index";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "/account/login";
    }

}
