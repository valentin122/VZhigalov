package ru.job4j.tracker;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Tracker
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 02.01.19
 */

class Tracker {

    private Item[] items = new Item[100];
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
        int rn = ThreadLocalRandom.current().nextInt(1, 10);
        return String.valueOf(System.currentTimeMillis() + rn);
    }

    public boolean replace(String id, Item item){
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = true;
                item.setId(id);
                items[i] = item;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id){
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = true;
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                break;
            }
        }
        return result;
    }

    public Item[] findAll(){
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String name){
        int count = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(name)) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item findById(String id){
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
}