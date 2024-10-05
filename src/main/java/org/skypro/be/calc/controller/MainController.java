package org.skypro.be.calc.controller;

import org.skypro.be.calc.utils.ResponseFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping()
    public String getGreetingMessage() {
        return ResponseFormatter.getGreetingMessage();
    }
}
