package ru.job4j.tracker;


import java.util.concurrent.ThreadLocalRandom;



/**
 * Tracker
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 02.01.19
 */

class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */

    public Item add(Item item){
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        int rn = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        return String.valueOf(System.currentTimeMillis() + rn);
    }

    public boolean replace(String id, Item item){
    }

    public boolean delete(String id){
        return false;
    }

    public Item[] findAll(){
    }

    public Item[] findByName(String key){
    }

    public Item findById(String id){
    }


}