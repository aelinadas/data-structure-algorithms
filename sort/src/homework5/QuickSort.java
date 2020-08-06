/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

import java.util.Arrays;

/**
 *
 * @author aelinadas
 */
public class QuickSort {
    private void quickSort(int[] inputArray, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int center = inputArray[firstIndex];
            int i = firstIndex;
            int j = lastIndex;
            while (i < j) {
                i += 1;
                while (i <= lastIndex && inputArray[i] < center) {
                    i += 1;
                }
                while (j >= firstIndex && inputArray[j] > center) {
                    j -= 1;
                }
                if (i <= lastIndex && i < j) {
                    quickSwap(inputArray, i, j);
                }
            }
            quickSwap(inputArray, firstIndex, j);
            quickSort(inputArray, firstIndex, j - 1);
            quickSort(inputArray, j + 1, lastIndex);
        }
    }

    private void quickSwap(int[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20};
        QuickSort sort = new QuickSort();
        sort.quickSort(in, 0, in.length - 1);
        System.out.println(Arrays.toString(in));
    }
}
