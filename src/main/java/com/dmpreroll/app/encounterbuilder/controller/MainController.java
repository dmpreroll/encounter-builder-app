package com.dmpreroll.app.encounterbuilder.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("applicationName", applicationName);
        return "index";
    }
}
