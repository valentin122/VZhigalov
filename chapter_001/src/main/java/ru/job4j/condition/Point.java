/**
 *Point
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 12.06.18
 *@version 0.1
 */

package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;

        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static double distance(int x1, int y1, int x2, int y2) {
    /*    Point pointOne = new Point(x1, y1);
        Point pointTwo = new Point(x2, y2);*/
        int operOne = x2 - x1;
        int operTwo = y2 - y1;
        double operThree = Math.pow(operOne, 2);
        double operFour = Math.pow(operTwo, 2);
        double operFive = operThree + operFour;
        double rsl = Math.sqrt(operFive);
        return rsl;
    }
    public static void main(String[] args) {

        int x1 = 0;
        int y1 = 5;
        int x2 = 7;
        int y2 = 10;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        double rsl2 = distance(x1, y1, x2, y2);
        System.out.println("x1 = " + a.x);
        System.out.println("x2 = " + b.x);
        System.out.println("y1 = " + a.y);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
        System.out.println("Расстояние между точками А и В : " + rsl2);
    }
    @SuppressWarnings("checkstyle:WhitespaceAround")
    public static boolean isSorted(int[] array) {
        boolean rsl = false;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length) {
                rsl = array[i] < array[i + 1];
            }
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }


}