package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * StartUI
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 16.01.19
 */

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    Exit exitProgram = new Exit();
    public void  init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Please, select a menu item:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
                exitProgram.execute();
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0.Add new item");
        System.out.println("1.Show all items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find item by id");
        System.out.println("5.Find item by name");
        System.out.println("6.Exit program");
    }

    /**
     * Create Item
     */
    private void createItem() {
        System.out.println("------------ Add new request --------------");
        String name = this.input.ask("Enter request name:");
        String desc = this.input.ask("Enter request description:");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Added new request with getId : " + item.getId() + "-----------");
    }

    private void show(String title, Item[] items) {
        System.out.println(title);
        System.out.printf("%-20s%-11s%-25s%-11s%n", "Id", "Name", "Description", "Changed");
        System.out.println("------------------------------------------------------------------------------");
        for (Item item : items) {
            System.out.printf("%-20s%-11s%-25s%-11s%n",
                    item.getId(), item.getName(), item.getDesc(), longToDate(item.getCreate()));
        }
        System.out.println("------------------------------------------------------------------------------");
    }

    private void showAllItems() {
        String title = "------------------------------ Show all requests -----------------------------";
        show(title, tracker.findAll());
    }
    private void editItem() {
        String title = "------------------------------ Edit some request ------------------------------";
        show(title, tracker.findAll());
        String id = input.ask("Enter id request");
        String name = input.ask("Enter request name");
        String desc = input.ask("Enter request description");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            System.out.printf("Request where id %s have changed%n", id);
        } else {
            System.out.printf("Request where id %s haven't changed%n", id);
        }
    }
    private void deleteItem() {
        String title = "----------------------------- Delete some request -----------------------------";
        show(title, tracker.findAll());
        String id = input.ask("Enter id request");
        if (tracker.delete(id)) {
            System.out.printf("Request deleted");
        } else {
            System.out.printf("Can't deleted request");
        }
    }
    private void findById() {
        String title = "----------------------------- Find by Id -------------------------------------";
        System.out.println();
        String id = input.ask("Enter id request");
        Item[] item = {tracker.findById(id)};
        if (item[0] == null) {
            System.out.printf("Request where id %s haven't found%n", id);
        } else {
            show(title, item);
        }
    }
    private void findByName() {
        String title = "-------------------------------- Find by name --------------------------------";
        System.out.println();
        String name = input.ask("Enter name request");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.printf("Request where name %s haven't found", name);
        } else {
            show(title, item);
        }
    }

    private String longToDate(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd,MM,yy");
        return sdf.format(new Date(date));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
class Exit {
    public int key() {
        return 0;
    }
    public void execute() {
        System.out.println("The selected menu item 0. Exit. Goodbye!");
    }
}

