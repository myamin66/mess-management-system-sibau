package com.iba.messmanagementsystem.controllers.documentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ApiDocController {
    @GetMapping("/api-documentation")
    public String apiDocumentation(){
        return "redirect:/swagger-ui.html";
    }
}
