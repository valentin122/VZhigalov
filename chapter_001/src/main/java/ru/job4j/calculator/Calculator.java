/**
 *Calculator
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 07.06.18
 *@version 0.1
 */

package ru.job4j.calculator;

public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    public void div(double first, double second) {
        this.result = first / second;

        }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult(){
        return this.result;
    }
}