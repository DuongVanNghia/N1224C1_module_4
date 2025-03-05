package com.n1224C1.techzen.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/greeeting")
    public String greeting(@RequestParam(defaultValue = "") String name) {
        return "Hello World! "+name;
    }
}
