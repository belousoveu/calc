package org.skypro.be.calc.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CalcService implements PageService {

    @Override
    public String getAnswerMessage(String o, String num1, String num2) {
        try {
            Operator operator = Operator.getByName(o);
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            return this.formatResultMessage(a, b, operator, operator.calculate(a, b));
        } catch (IllegalArgumentException | ArithmeticException e) {
            return this.formatErrorMessage(e.getMessage());
        }
    }

    @Override
    public String getGreetingMessage() {
        return """
                <h1>Приветствую вас на сервере</h1></br>
                <h3><a href="http://localhost:8080/calc">Калькулятор</a></h3></br>
                """;
    }

    @Override
    public String getPageGreetingMessage() {
        return this.getCalcTitle() + this.getCalcHelpMessage();
    }

    @Override
    public String getErrorMessage(String errorMessage) {
        return this.formatErrorMessage(errorMessage);
    }

    private String getCalcHelpMessage() {
        return """
                <h4>Синтаксис операций: <b>/calc/{operator}?num1=5&num2=5</b></h4></br>
                <h4>Допустимые операторы {operator}:</h4></br>
                <ul>add - сложение</li></br>sub - вычитание</li></br>mul - умножение</li>
                </br>div - деление</li></br>pow - возведение в степень</li></br>
                """;
    }

    private String getCalcTitle() {
        return "<h1>Калькулятор</h1></br>";
    }

    private String formatErrorMessage(String errorMessage) {
        return new StringBuilder().append(this.getCalcTitle())
                .append("<h3 style=\"color:red\"><b>")
                .append("Ошибка :").append(errorMessage)
                .append("</b></h3></br>")
                .append(this.getCalcHelpMessage()).toString();
    }

    private String formatResultMessage(double a, double b, Operator operator, double result) {
        DecimalFormat df = new DecimalFormat("#.########");
        df.setGroupingUsed(true);
        df.setDecimalSeparatorAlwaysShown(false);
        return new StringBuilder().append(this.getCalcTitle())
                .append("<h3><b>")
                .append(String.format("Результат: %s %s %s = %s", df.format(a), operator.getSymbol(), df.format(b),
                        df.format(result)))
                .append("</b></h3></br>")
                .append(this.getCalcHelpMessage())
                .toString();
    }
}
