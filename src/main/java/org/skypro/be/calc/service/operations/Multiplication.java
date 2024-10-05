package org.skypro.be.calc.service.operations;

import org.springframework.stereotype.Component;

@Component
public class Multiplication implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }

    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public String getName() {
        return "mul";
    }
}
