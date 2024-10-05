package org.skypro.be.calc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.be.calc.service.operations.Operation;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalcServiceParameterizedTest {

    @InjectMocks
    private CalcServiceImp calcService;

    @Mock
    private OperationFactory operationFactory;

    @Mock
    private Operation addition;

    @Mock
    private Operation subtraction;

    @Mock
    private Operation multiplication;

    @Mock
    private Operation division;

    @Mock
    private Operation power;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(addition.getSymbol()).thenReturn("+");
        when(subtraction.getSymbol()).thenReturn("-");
        when(multiplication.getSymbol()).thenReturn("*");
        when(division.getSymbol()).thenReturn("/");
        when(power.getSymbol()).thenReturn("^");
    }

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("add", 5, 2, 7),
                Arguments.of("sub", 5, 2, 3),
                Arguments.of("mul", 5, 2, 10),
                Arguments.of("div", 5, 2, 2.5),
                Arguments.of("pow", 5, 2, 25));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void checkCalculate(String operator, double a, double b, double expected) {
        Operation operation = switch (operator) {
            case "add" -> addition;
            case "sub" -> subtraction;
            case "mul" -> multiplication;
            case "div" -> division;
            case "pow" -> power;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };

        when(operation.calculate(a, b)).thenReturn(expected);
        when(operationFactory.getOperation(operator)).thenReturn(operation);

        assertEquals(expected, calcService.calculate(operator, a, b));
        verify(operation).calculate(a, b);

    }

}
