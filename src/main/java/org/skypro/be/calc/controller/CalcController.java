package org.skypro.be.calc.controller;

import org.skypro.be.calc.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.annotation.Target;


@RestController
public class CalcController {
    PageService pageService;

    public CalcController(PageService calcService) {
        this.pageService = calcService;
    }

    @GetMapping()
    public String getGreetingMessage() {
        return pageService.getGreetingMessage();
    }

    @GetMapping({"/calc", "/calc/"})
    public String getCalcMessage() {
        return pageService.getPageGreetingMessage();
    }

    @GetMapping("/calc/{operator}")
    public String getCalc(@PathVariable String operator, @RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return pageService.getAnswerMessage(operator, num1, num2);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<String> handleMissingParams(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pageService.getErrorMessage(ex.getMessage()));
    }
}

