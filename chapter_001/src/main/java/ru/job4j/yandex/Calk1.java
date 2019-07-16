package ru.job4j.yandex;

import java.util.Scanner;

class Calk1 {
    public static void main(String[] args) {
        //System.out.print("Введите любые целые числа A и B от -2*10^9 до 2*10^9: ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int result = a + b;
        System.out.println(result);
    }
}
