package com.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("/")
    public String getIndex() {
        return "/shop/index";
    }
}
