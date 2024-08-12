package org.skypro.be.calc.service;

public enum Operator {
    ADD("+", "add"),
    SUB("-", "sub"),
    MUL("*", "mul"),
    DIV("/", "div"),
    POW("^", "pow");

    private final String symbol;
    private final String name;

    Operator(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public static Operator getByName(String name) {
        for (Operator operator : Operator.values()) {
            if (operator.getName().equalsIgnoreCase(name)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator :" + name);
    }

    public double calculate(double a, double b) {
        return switch (this) {
            case ADD -> a + b;
            case SUB -> a - b;
            case MUL -> a * b;
            case DIV -> {
                if (b == 0) {throw new IllegalArgumentException("Division by zero is not allowed");}
                yield a / b;
            }
            case POW -> Math.pow(a, b);
        };
    }

    @Override
    public String toString() {
        return this.name;
    }
}
