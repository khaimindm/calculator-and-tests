package ru.khaimin.dmitrii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.khaimin.dmitrii.exception.NotCorrectCharacterInExpressionException;
import ru.khaimin.dmitrii.service.ValidationCheck;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    private static ValidationCheck validationCheck;

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
}