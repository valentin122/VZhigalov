/**
 *dummybot
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 17.06.18
 *@version 0.1
 */

package ru.job4j.dummybot;

public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = ("До скорой встречи.");
        }
        return rsl;
    }
}