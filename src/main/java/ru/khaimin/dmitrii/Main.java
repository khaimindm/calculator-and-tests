package ru.khaimin.dmitrii;

import ru.khaimin.dmitrii.exception.NotCorrectCharacterInExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectOperationException;
import ru.khaimin.dmitrii.service.Calculations;

public class Main {
    public static void main(String[] args) throws NotCorrectExpressionException, NotCorrectCharacterInExpressionException, NotCorrectOperationException {
        Calculations calculations = new Calculations();
        calculations.run();
    }
}