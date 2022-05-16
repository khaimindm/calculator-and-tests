package ru.khaimin.dmitrii.service;

import java.util.Scanner;

public class WorkingWithTheConsole {
    public String getExpression() {
        System.out.println("Введите выражение для вычисления");
        Scanner in = new Scanner(System.in);
        String inputExpression = in.nextLine();
        return inputExpression;
    }

    public void print(Double number) {
        double d = new Double(number);
        int intTypeNumber;
        if (number % 1 == 0) {
            intTypeNumber = (int)d;
            System.out.println(intTypeNumber);
        } else {
            System.out.println(number);
        }
    }
}