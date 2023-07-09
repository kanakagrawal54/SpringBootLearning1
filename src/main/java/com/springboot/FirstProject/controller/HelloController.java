package com.springboot.FirstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String Hello()
    { return "Welcome  to the first project ";
        //System.out.println("Welcome to the first");
    }
}
