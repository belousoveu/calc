package org.skypro.be.calc.service;

public interface CalcService {


    double calculate(String operator, double num1, double num2);

    String getOperatorSymbol(String name);
}
