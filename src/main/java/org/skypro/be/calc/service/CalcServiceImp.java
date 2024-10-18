package org.skypro.be.calc.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CalcServiceImp implements CalcService {

    OperationFactory operationFactory;

    public CalcServiceImp(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    @Override
    public double calculate(String name, double num1, double num2) {
        return operationFactory.getOperation(name).calculate(num1, num2);
    }

    @Override
    public String getOperatorSymbol(String name) {
        return operationFactory.getOperation(name).getSymbol();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcServiceImp that = (CalcServiceImp) o;
        return Objects.equals(operationFactory, that.operationFactory);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(operationFactory);
    }
}
