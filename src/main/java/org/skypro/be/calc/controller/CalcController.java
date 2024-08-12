package org.skypro.be.calc.controller;

import org.skypro.be.calc.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/calc")
    public String getCalcMessage() {
        return pageService.getPageGreetingMessage();
    }

    @GetMapping("/calc/{operator}")
    public String getCalc(@PathVariable String operator, @RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return pageService.getAnswerMessage(operator, num1, num2);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParams(MissingServletRequestParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pageService.getErrorMessage(ex.getMessage()));
    }
}

