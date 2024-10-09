package org.skypro.be.calc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.be.calc.service.operations.Operation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalcServiceImpTest {

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

    @InjectMocks
    private  CalcServiceImp out;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(operationFactory.getOperation("add")).thenReturn(addition);
        when(operationFactory.getOperation("ADD")).thenReturn(addition);
        when(operationFactory.getOperation("sub")).thenReturn(subtraction);
        when(operationFactory.getOperation("mul")).thenReturn(multiplication);
        when(operationFactory.getOperation("div")).thenReturn(division);
        when(operationFactory.getOperation("pow")).thenReturn(power);
        when(operationFactory.getOperation("unknown")).thenThrow(IllegalArgumentException.class);
        when(addition.calculate(9, 3)).thenReturn(12.0);
        when(subtraction.calculate(9, 3)).thenReturn(6.0);
        when(multiplication.calculate(9, 3)).thenReturn(27.0);
        when(division.calculate(9, 3)).thenReturn(3.0);
        when(power.calculate(9, 3)).thenReturn(729.0);
        when(division.calculate(9, 0)).thenThrow(IllegalArgumentException.class);
        when(addition.getSymbol()).thenReturn("+");
        when(subtraction.getSymbol()).thenReturn("-");
        when(multiplication.getSymbol()).thenReturn("*");
        when(division.getSymbol()).thenReturn("/");
        when(power.getSymbol()).thenReturn("^");


    }

    @Test
    void checkAddOperation() {
        assertEquals(12.0, out.calculate("add", 9, 3));
    }

    @Test
    void checkSubOperation() {
        assertEquals(6.0, out.calculate("sub", 9, 3));
    }

    @Test
    void checkMultiplicityOperation() {
        assertEquals(27.0, out.calculate("mul", 9, 3));
    }

    @Test
    void checkDivisionOperation() {
        assertEquals(3.0, out.calculate("div", 9, 3));
    }

    @Test
    void checkPowOperation() {
        assertEquals(729.0, out.calculate("pow", 9, 3));
    }

    @Test
    void checkDivideByZeroOperation() {
        assertThrows(IllegalArgumentException.class, () -> out.calculate("div", 9, 0));
    }

    @Test
    void checkGetCorrectSymbolAddOperation() {
        assertEquals("+", out.getOperatorSymbol("add"));
    }

    @Test
    void checkGetCorrectSymbolSubOperation() {
        assertEquals("-", out.getOperatorSymbol("sub"));
    }

    @Test
    void checkGetCorrectSymbolMultiOperation() {
        assertEquals("*", out.getOperatorSymbol("mul"));
    }

    @Test
    void checkGetCorrectSymbolDivOperation() {
        assertEquals("/", out.getOperatorSymbol("div"));
    }

    @Test
    void checkGetCorrectSymbolPowOperation() {
        assertEquals("^", out.getOperatorSymbol("pow"));
    }

    @Test
    void checkUnknownOperationException() {
        assertThrows(IllegalArgumentException.class, () -> out.getOperatorSymbol("unknown"));
    }

    @Test
    void checkGetCorrectSymbolInUpperCase() {
        assertEquals("+", out.getOperatorSymbol("ADD"));
    }

}