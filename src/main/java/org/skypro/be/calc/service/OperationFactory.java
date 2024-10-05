package org.skypro.be.calc.service;

import org.skypro.be.calc.exception.InvalidOperatorException;
import org.skypro.be.calc.service.operations.Operation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationFactory {

    private final List<Operation> operations;

    public OperationFactory(List<Operation> operations) {
        this.operations = operations;
    }

    public Operation getOperation(String operator) {
        return operations.stream().filter(operation -> operation.getName().equalsIgnoreCase(operator))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("Invalid operator: " + operator));
    }

}
