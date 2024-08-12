package org.skypro.be.calc.service;

public interface PageService {
    String getAnswerMessage(String o, String num1, String num2);

    String getGreetingMessage();

    String getPageGreetingMessage();

    String getErrorMessage(String errorMessage);
}
