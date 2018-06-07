/**
 *Calculator
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 08.06.18
 *@version 0.1
 */

package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    private int result;

    final static int rubToEu = 70;
    final static int rubToDol = 60;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        result = value / rubToEu;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        result = value / rubToDol;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */

    public int dollarToRubles(int value) {
        result = value * rubToDol;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли
     */

    public int euroToRubles(int value) {
        result = value * rubToEu;
        return this.result;
    }


}
