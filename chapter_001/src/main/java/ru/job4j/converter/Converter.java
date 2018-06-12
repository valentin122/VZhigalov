/**
 *Calculator
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 08.06.18
 *@version 0.2
 */

package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    final private static int RUBLESTOEURO = 70;
    final private static int RUBLESTODOLLAR = 60;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / RUBLESTOEURO;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / RUBLESTODOLLAR;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */

    public int dollarToRubles(int value) {
        return value * RUBLESTODOLLAR;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли
     */

    public int euroToRubles(int value) {
        return value * RUBLESTOEURO;
    }


}
