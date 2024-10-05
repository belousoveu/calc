package org.skypro.be.calc.controller;

import org.skypro.be.calc.service.CalcService;
import org.skypro.be.calc.utils.ResponseFormatter;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calc")
public class CalcController {
    CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("")
    public String getCalcMessage() {
        return ResponseFormatter.getCalcGreetingMessage();
    }

    @GetMapping("/{operator}")
    public String getCalc(@PathVariable String operator, @RequestParam double num1, @RequestParam double num2) {
        double result = calcService.calculate(operator, num1, num2);
        return ResponseFormatter.getCalcResultMessage(calcService.getOperatorSymbol(operator), num1, num2, result);
    }

}

