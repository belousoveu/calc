package org.skypro.be.calc.service.operations;

public interface Operation {

    double calculate(double a, double b);

    String getSymbol();

    String getName();
}
