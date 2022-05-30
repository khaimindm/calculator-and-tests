package ru.khaimin.dmitrii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.khaimin.dmitrii.exception.NotCorrectCharacterInExpressionException;
import ru.khaimin.dmitrii.exception.NotCorrectExpressionException;
import ru.khaimin.dmitrii.service.ValidationCheck;

import static org.junit.jupiter.api.Assertions.*;

class ValidationCheckTest {

    private static ValidationCheck validationCheck;

    @BeforeEach
    void setUp() {
        validationCheck = new ValidationCheck();
    }

    @Test
    void testCheckCorrectness() throws NotCorrectExpressionException {
        Assertions.assertTrue(validationCheck.checkCorrectness("25+5"));
    }

    @Test
    void testCheckValidity() throws NotCorrectCharacterInExpressionException {
        Assertions.assertTrue(validationCheck.checkValidity("25+5"));
    }
}