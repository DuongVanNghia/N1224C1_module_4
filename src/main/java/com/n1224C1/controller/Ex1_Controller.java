package com.n1224C1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex1_Controller {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name) {
        return "Hello "+name+"!!!";
    }
}
