package ru.khaimin.dmitrii;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import ru.khaimin.dmitrii.exception.NotCorrectOperationException;
import ru.khaimin.dmitrii.service.Parsing;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//@RunWith(JUnitParamsRunner.class)

public class ArithmeticTest {

    private static Parsing parsing;
    private double error = 0.00001;

    @Before
    public void setUp() throws Exception {
        parsing = new Parsing();
    }

    @ParameterizedTest
    @MethodSource("methodSumIntDataProvider")

    public void sumInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dSumInt = new Double(parsing.parseExpression(first + "+" + second));
        int intTypeNumber = (int)dSumInt;
        Assertions.assertEquals(expected, intTypeNumber);
    }

    static Stream<Arguments> methodSumIntDataProvider() {
        return Stream.of(
                Arguments.arguments(250, 5, 255),
                Arguments.arguments(30, 45, 75)
        );
    }

    @ParameterizedTest
    @MethodSource("methodSumDoubleDataProvider")
    public void sumDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dSumDouble = new Double(parsing.parseExpression(first + "+" + second));
        assertThat(dSumDouble, closeTo(expected, error));
    }

    static Stream<Arguments> methodSumDoubleDataProvider() {
        return Stream.of(
                Arguments.arguments(45.123, 5.002, 50.125),
                Arguments.arguments(30.12344, 10.00001, 40.12345),
                Arguments.arguments(10.12345678, 1, 11.12345678)
        );
    }

    @ParameterizedTest
    @MethodSource("methodDifferenceIntDataProvider")
    public void differenceInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dDifferenceInt = new Double(parsing.parseExpression(first + "-" + second));
        int intTypeNumber = (int)dDifferenceInt;
        Assertions.assertEquals(expected, intTypeNumber);
    }

    static Stream<Arguments> methodDifferenceIntDataProvider() {
        return Stream.of(
                Arguments.arguments(255, 5, 250),
                Arguments.arguments(30, 45, -15)
        );
    }

    @ParameterizedTest
    @MethodSource("methodDifferenceDoubleDataProvider")
    public void differenceDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dDifferenceDouble = new Double(parsing.parseExpression(first + "-" + second));
        assertThat(dDifferenceDouble, closeTo(expected, error));
    }

    static Stream<Arguments> methodDifferenceDoubleDataProvider() {
        return Stream.of(
                Arguments.arguments(45.123, 0.123, 45.0),
                Arguments.arguments(11.12345678, 1, 10.12345678)
        );
    }

    @ParameterizedTest
    @MethodSource("methodMultiplicationIntDataProvider")
    public void multiplicationInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dMultiplicationInt = new Double(parsing.parseExpression(first + "*" + second));
        int intTypeNumber = (int)dMultiplicationInt;
        Assertions.assertEquals(expected, intTypeNumber);
    }

    static Stream<Arguments> methodMultiplicationIntDataProvider() {
        return Stream.of(
                Arguments.arguments(2, 5, 10),
                Arguments.arguments(30, 40, 1200)
        );
    }

    @ParameterizedTest
    @MethodSource("methodMultiplicationDoubleDataProvider")
    public void multiplicationDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dMultiplicationDouble = new Double(parsing.parseExpression(first + "*" + second));
        assertThat(dMultiplicationDouble, closeTo(expected, error));
    }

    static Stream<Arguments> methodMultiplicationDoubleDataProvider() {
        return Stream.of(
                Arguments.arguments(5.0, 2.0, 10.0),
                Arguments.arguments(5.2, 2.0, 10.4),
                Arguments.arguments(10.12345678, 1, 10.12345678)
        );
    }

    @ParameterizedTest
    @MethodSource("methodDivisionIntDataProvider")
    public void divisionInt(int first, int second, int expected) throws NotCorrectOperationException {
        double dDivisionInt = new Double(parsing.parseExpression(first + "/" + second));
        int intTypeNumber = (int)dDivisionInt;
        Assertions.assertEquals(expected, intTypeNumber);
    }

    static Stream<Arguments> methodDivisionIntDataProvider() {
        return Stream.of(
                Arguments.arguments(1, 2, 0),
                Arguments.arguments(10, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("methodDivisionDoubleDataProvider")
    public void divisionDouble(double first, double second, double expected) throws NotCorrectOperationException {
        double dDivisionDouble = new Double(parsing.parseExpression(first + "/" + second));
        assertThat(dDivisionDouble, closeTo(expected, error));
    }

    static Stream<Arguments> methodDivisionDoubleDataProvider() {
        return Stream.of(
                Arguments.arguments(10.0, 2.0, 5.0),
                Arguments.arguments(5.2, 2.0, 2.6),
                Arguments.arguments(10.12345678, 1, 10.12345678),
                Arguments.arguments(10.12345678, 22, 0.46015712636)
        );
    }
}