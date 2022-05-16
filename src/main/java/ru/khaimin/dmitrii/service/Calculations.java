package ru.khaimin.dmitrii.service;

import ru.khaimin.dmitrii.exception.NotCorrectCharacterInExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectOperationException;

public class Calculations {

    public void run() throws NotCorrectCharacterInExpressionException, NotCorrectExpressionException, NotCorrectOperationException {
        WorkingWithTheConsole workingWithTheConsole = new WorkingWithTheConsole();
        ValidationCheck validationCheck = new ValidationCheck();
        String expression = workingWithTheConsole.getExpression();
        if (validationCheck.checkCorrectness(expression) && validationCheck.checkValidity(expression)) {
            workingWithTheConsole.print(Parsing.parseExpression(expression));
        }
    }
}
