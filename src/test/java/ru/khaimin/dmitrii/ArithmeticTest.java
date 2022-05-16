package ru.khaimin.dmitrii;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.khaimin.dmitrii.exception.NotCorrectOperationException;
import ru.khaimin.dmitrii.service.Parsing;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitParamsRunner.class)

public class ArithmeticTest {

    private static Parsing parsing;

    @Before
    public void setUp() throws Exception {
        parsing = new Parsing();
    }

    @Test
    @Parameters({
            "250, 5, 255",
            "30, 45, 75"
    })
    public void sumInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dSumInt = new Double(parsing.parseExpression(first + "+" + second));
        int intTypeNumber = (int)dSumInt;
        assertThat(expected, comparesEqualTo(intTypeNumber));
    }

    @Test
    @Parameters({
            "45.123, 5.002, 50.125",
            "30.12344, 10.00001, 40.12345",
            "10.12345678, 1, 11.12345678"
    })
    public void sumDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dSumDouble = new Double(parsing.parseExpression(first + "+" + second));
        assertThat(expected, comparesEqualTo(dSumDouble));
    }

    @Test
    @Parameters({
            "255, 5, 250",
            "30, 45, -15"
    })
    public void differenceInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dDifferenceInt = new Double(parsing.parseExpression(first + "-" + second));
        int intTypeNumber = (int)dDifferenceInt;
        assertThat(expected, comparesEqualTo(intTypeNumber));
    }

    @Test
    @Parameters({
            "45.123, 0.123, 45.0",
            "11.12345678, 1, 10.12345678"
    })
    public void differenceDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dDifferenceDouble = new Double(parsing.parseExpression(first + "-" + second));
        assertThat(expected, comparesEqualTo(dDifferenceDouble));
    }
}