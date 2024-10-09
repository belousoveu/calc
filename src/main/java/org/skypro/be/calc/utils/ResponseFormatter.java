package org.skypro.be.calc.utils;

import java.text.DecimalFormat;

public class ResponseFormatter {

    public static String getGreetingMessage() {
        return """
                <h1>Приветствую вас на сервере</h1></br>
                <h3><a href="http://localhost:8080/calc">Калькулятор</a></h3></br>
                """;
    }

    public static String getCalcGreetingMessage() {
        return getCalcTitle().concat(getCalcHelpMessage());
    }

    public static String getCalcResultMessage(String operatorSymbol, double num1, double num2, double result) {
        DecimalFormat df = new DecimalFormat();
        df.setDecimalSeparatorAlwaysShown(false);
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMaximumFractionDigits(8);
        return getCalcTitle() +
                "<h3><b>" +
                String.format("Результат: %s %s %s = %s", df.format(num1), operatorSymbol, df.format(num2),
                        df.format(result)) +
                "</b></h3></br>" +
                getCalcHelpMessage();
    }

    public static String getErrorMessage(String errorMessage) {
        return getCalcTitle() +
                "<h3 style=\"color:red\"><b>" +
                "Ошибка :" + errorMessage +
                "</b></h3></br>" +
                getCalcHelpMessage();
    }

    private static String getCalcTitle() {
        return "<h1>Калькулятор</h1></br>";
    }

    private static String getCalcHelpMessage() {
        return """
                <h4>Синтаксис операций: <b>/calc/{operator}?num1=5&num2=5</b></h4></br>
                <h4>Допустимые операторы {operator}:</h4></br>
                <ul>add - сложение</li></br>sub - вычитание</li></br>mul - умножение</li>
                </br>div - деление</li></br>pow - возведение в степень</li></br>
                """;
    }

}
