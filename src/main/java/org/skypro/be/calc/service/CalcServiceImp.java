package org.skypro.be.calc.service;

import org.springframework.stereotype.Service;

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

}
