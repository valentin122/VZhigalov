package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Tracker
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 02.01.19
 */

public class Tracker {

    private ArrayList<Item> items = new ArrayList<>();
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position++, item);
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

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                result = true;
                item.setId(id);
                items.set(i, item);
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                result = true;
                items.remove(i);
                position--;
                break;
            }
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        /*ArrayList<Item> finded = new ArrayList<Item>(items.size());
        finded.addAll(items);

        for (Item item : items) {
            finded.add(item);
        }*/
        return items;
    }

    public ArrayList<Item> findByName(String name) {
        int count = 0;
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < position; i++) {
            if (items.get(i).getName().equals(name)) {
                result.add(items.get(i));
            }
        }
        return result; //Arrays.copyOf(result, count);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getId().equals(id)) {
                result = items.get(i);
                break;
            }
        }
        return result;
    }
}