package org.skypro.be.calc.service.operations;

import org.skypro.be.calc.exception.DivideByZeroException;
import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new DivideByZeroException("Division by zero is not allowed");
        }
        return a / b;
    }

    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public String getName() {
        return "div";
    }
}
