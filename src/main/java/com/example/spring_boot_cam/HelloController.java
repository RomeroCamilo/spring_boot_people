package com.example.spring_boot_cam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "index"; // This corresponds to src/main/resources/templates/index.html
    }

}

