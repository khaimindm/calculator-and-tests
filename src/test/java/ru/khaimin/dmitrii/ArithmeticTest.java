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
    private double error = 0.00001;

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
        assertThat(dSumDouble, closeTo(expected, error));
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
        assertThat(dDifferenceDouble, closeTo(expected, error));
    }

    @Test
    @Parameters({
            "2, 5, 10",
            "30, 40, 1200"
    })
    public void multiplicationInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dMultiplicationInt = new Double(parsing.parseExpression(first + "*" + second));
        int intTypeNumber = (int)dMultiplicationInt;
        assertThat(expected, comparesEqualTo(intTypeNumber));
    }

    @Test
    @Parameters({
            "5.0, 2.0, 10.0",
            "5.2, 2.0, 10.4",
            "10.12345678, 1, 10.12345678"
    })
    public void multiplicationDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dMultiplicationDouble = new Double(parsing.parseExpression(first + "*" + second));
        assertThat(dMultiplicationDouble, closeTo(expected, error));
    }

    @Test
    @Parameters({
            "1, 2, 0",
            "10, 2, 5"
    })
    public void divisionInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dDivisionInt = new Double(parsing.parseExpression(first + "/" + second));
        int intTypeNumber = (int)dDivisionInt;
        assertThat(expected, comparesEqualTo(intTypeNumber));
    }

    @Test
    @Parameters({
            "10.0, 2.0, 5.0",
            "5.2, 2.0, 2.6",
            "10.12345678, 1, 10.12345678",
            "10.12345678, 22, 0.46015712636"
    })
    public void divisionDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dDivisionDouble = new Double(parsing.parseExpression(first + "/" + second));
        assertThat(dDivisionDouble, closeTo(expected, error));
    }
}