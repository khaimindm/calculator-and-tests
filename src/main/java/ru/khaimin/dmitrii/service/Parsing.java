package ru.khaimin.dmitrii.service;

import ru.khaimin.dmitrii.exception.NotCorrectOperationException;

import java.util.LinkedList;

public class Parsing {
    static boolean isWhitespace(char c) {
        return c == ' ';
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    static void calculate(LinkedList<Double> numbers, char currentCharacter) throws NotCorrectOperationException {
        double r = numbers.removeLast();
        double l = numbers.removeLast();
        switch (currentCharacter) {
            case '+':
                numbers.add(l + r);
                break;
            case '-':
                numbers.add(l - r);
                break;
            case '*':
                numbers.add(l * r);
                break;
            case '/':
                if (r == 0) {
                    throw new NotCorrectOperationException("Недопустимая операция.");
                }
                numbers.add(l / r);
                break;
        }
    }

    public static Double parseExpression(String expression) throws NotCorrectOperationException {
        LinkedList<Double> numbers = new LinkedList<Double>();
        LinkedList<Character> operator = new LinkedList<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isWhitespace(c)) {
                continue;
            }

            if (isOperator(c)) {
                while (!operator.isEmpty() && priority(operator.getLast()) >= priority(c)) {
                    calculate(numbers, operator.removeLast());
                }
                operator.add(c);
            } else {
                String operand = "";
                while (i < expression.length() && Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') {
                    operand += expression.charAt(i++);
                    if (i >= expression.length()) {
                        break;
                    }
                }
                --i;
                numbers.add(Double.parseDouble(operand));
            }
        }
        while (!operator.isEmpty()) {
            calculate(numbers, operator.removeLast());
        }
        return numbers.get(0);
    }
}