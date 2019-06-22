package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() / rows) + ((list.size() % rows == 0) ? 0 : 1);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (int count : list) {
            array[row][cell] = count;
            cell++;
            if (cell == cells) {
                row++;
                cell = 0;
            }
        }
        /*int index = 0;
        for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cells; c++) {
                    if (index >= list.size()) {
                        array[r][c] = 0;
                    } else {
                        array[r][c] = list.get(index);
                        index++;
                    }
                }
            }*/
        return array;
    }
}