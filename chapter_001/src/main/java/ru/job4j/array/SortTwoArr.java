/**
 * SortTwoArr
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 11.11.18
 */

package ru.job4j.array;

public class SortTwoArr {
    /**
     * method merged 2 array in one
     *
     * @param arrayOne any int sorted array
     * @param arrayTwo any int sorted array
     * @return united sorted array
     */
    public int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] mergedArray = new int[arrayOne.length + arrayTwo.length];

        int i = 0, j = 0;
        int mergedArrayIndex = 0;
        for (; i < arrayOne.length || j < arrayTwo.length;) {
            if (i < arrayOne.length && j < arrayTwo.length) {
                if (arrayOne[i] < arrayTwo[j]) {
                    mergedArray[mergedArrayIndex] = arrayOne[i];
                    i++;
                } else {
                    mergedArray[mergedArrayIndex] = arrayTwo[j];
                    j++;
                }
            } else if (i < arrayOne.length) {
                mergedArray[mergedArrayIndex] = arrayOne[i];
                i++;
            } else if (j < arrayTwo.length) {
                mergedArray[mergedArrayIndex] = arrayTwo[j];
                j++;
            }
            mergedArrayIndex++;
        }
        return mergedArray;

    }
}