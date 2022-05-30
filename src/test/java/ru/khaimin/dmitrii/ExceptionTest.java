package ru.khaimin.dmitrii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.khaimin.dmitrii.exception.NotCorrectCharacterInExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectOperationException;
import ru.khaimin.dmitrii.service.Parsing;
import ru.khaimin.dmitrii.service.ValidationCheck;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    private static ValidationCheck validationCheck;
    private static Parsing parsing;

    @BeforeEach
    void setUp() throws Exception {
        validationCheck = new ValidationCheck();
    }

    @Test
    public void  testNotCorrectCharacterInExpressionException() {
        NotCorrectCharacterInExpressionException thrown = Assertions.assertThrows(NotCorrectCharacterInExpressionException.class, () -> {
            validationCheck.checkValidity("25+8*2&2");
        }, "NotCorrectCharacterInExpressionException was expected");
        Assertions.assertEquals("В введенном выражении используются недопустимые символы. " +
                "Допустимые символы: '0-9', '+', '-', '*', '/', '.'. Введите корректное выражение.", thrown.getMessage());
    }

    @Test
    public void testNotCorrectExpressionEmptyException() {
        NotCorrectExpressionException thrown = Assertions.assertThrows(NotCorrectExpressionException.class, () -> {
            validationCheck.checkCorrectness("");
        }, "NotCorrectExpressionException was expected");
        Assertions.assertEquals("Передана пустая строка. Выражение не должно быть пустым.", thrown.getMessage());
    }

    @Test
    public void testNotCorrectExpressionOperatorAtTheBeginningException() {
        NotCorrectExpressionException thrown = Assertions.assertThrows(NotCorrectExpressionException.class, () -> {
            validationCheck.checkCorrectness("-2*10");
        }, "NotCorrectExpressionException was expected");
        Assertions.assertEquals("Введено некорректное выражение. В выражении не должно быть" +
                " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.", thrown.getMessage());
    }

    @Test
    public void testNotCorrectExpressionOperatorAtTheEndException() {
        NotCorrectExpressionException thrown = Assertions.assertThrows(NotCorrectExpressionException.class, () -> {
            validationCheck.checkCorrectness("2*10+");
        }, "NotCorrectExpressionException was expected");
        Assertions.assertEquals("Введено некорректное выражение. В выражении не должно быть" +
                " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.", thrown.getMessage());
    }

    @Test
    public void testNotCorrectExpressionTwoOperatorsException() {
        NotCorrectExpressionException thrown = Assertions.assertThrows(NotCorrectExpressionException.class, () -> {
            validationCheck.checkCorrectness("2*+10");
        }, "NotCorrectExpressionException was expected");
        Assertions.assertEquals("Введено некорректное выражение. В выражении не должно быть" +
                " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.", thrown.getMessage());
    }

    @Test
    public void testNotCorrectExpressionTwoPointsException() {
        NotCorrectExpressionException thrown = Assertions.assertThrows(NotCorrectExpressionException.class, () -> {
            validationCheck.checkCorrectness("2..5+10");
        }, "NotCorrectExpressionException was expected");
        Assertions.assertEquals("Введено некорректное выражение. В выражении не должно быть" +
                " дублирующихся символов операций. В выражении нельзя использовать отрицательные числа.", thrown.getMessage());
    }

    @Test
    public void testNotCorrectOperationException() {
        NotCorrectOperationException thrown = Assertions.assertThrows(NotCorrectOperationException.class, () -> {
            parsing = new Parsing();
            parsing.parseExpression("2*5/0");
        }, "NotCorrectOperationException was expected");
        Assertions.assertEquals("Недопустимая операция.", thrown.getMessage());
    }
}