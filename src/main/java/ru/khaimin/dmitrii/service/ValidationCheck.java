package ru.khaimin.dmitrii.service;

import ru.khaimin.dmitrii.exception.NotCorrectCharacterInExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectExpressionException;

public class ValidationCheck {
    public boolean checkValidity(String expression) throws NotCorrectCharacterInExpressionException {
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == ' ' || c == '+' || c == '-' || c == '*' || c == '/' || c == '.') {
                continue;
            } else {
                throw new NotCorrectCharacterInExpressionException("В введенном выражении используются недопустимые символы. " +
                        "Допустимые символы: '0-9', '+', '-', '*', '/', '.'. Введите корректное выражение.");
            }
        }
        return true;
    }

    public boolean checkCorrectness(String expression) throws NotCorrectExpressionException {
        ValidationCheck validationCheck = new ValidationCheck();
        if (expression.isEmpty()) {
            throw new NotCorrectExpressionException("Передана пустая строка. Выражение не должно быть пустым.");
        }

        if (validationCheck.isOperator(expression.charAt(0)) || validationCheck.isOperator(expression.charAt(
                expression.length() - 1))) {
            throw new NotCorrectExpressionException("Введено некорректное выражение. В выражении не должно быть" +
                    " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.");
        }

        for (int i = 0; i < expression.length() - 1; i++) {
            if (validationCheck.isOperator(expression.charAt(i)) && validationCheck.isOperator(expression.charAt(i + 1))) {
                throw new NotCorrectExpressionException("Введено некорректное выражение. В выражении не должно быть" +
                        " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.");
            }

            if (expression.charAt(i) == '.' && expression.charAt(i + 1) == '.') {
                throw new NotCorrectExpressionException("Введено некорректное выражение. В выражении не должно быть" +
                        " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.");
            }
        }
        return true;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}