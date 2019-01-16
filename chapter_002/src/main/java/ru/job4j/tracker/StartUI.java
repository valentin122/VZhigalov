package ru.job4j.tracker;

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





    public StartUI(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }
    public void  init(){
        boolean exit = false;
        while (!exit){
            this.showMenu();
            String answer = this.input.ask("Please, select a menu item:");
            if(ADD.equals(answer)){
                this.createItem();
            } else if (SHOW.equals(answer)){
                this.showAllItems();
            } else if (EDIT.equals(answer)){
                this.editItem();
            } else if (DELETE.equals(answer)){
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)){
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)){
                this.findByName();
            } else if (EXIT.equals(answer)){
                exit = true;
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

    private void show(String title, Item[] items){
        System.out.println(title);
        //добавить
    }

    private void showAllItems(){
        String title = "------------------------------ Show all requests -----------------------------";
        show(title, tracker.findAll());
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }


}

