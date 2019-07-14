package ru.job4j.yandex;

import java.util.Scanner;

class Calk1 {
    public static void main(String args[]){
        //System.out.print("Введите любые целые числа A и B от -2*10^9 до 2*10^9: ");
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int result = A + B;
        System.out.println (result);
    }
}