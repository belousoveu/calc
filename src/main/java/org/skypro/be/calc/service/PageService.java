package org.skypro.be.calc.service;

public interface PageService {
    String getAnswerMessage(String o, double num1, double num2);

    String getGreetingMessage();

    String getPageGreetingMessage();

    String getErrorMessage(String errorMessage);
}
