package com.mani.sorting.quick;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] array ={2,6,7,1,8};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
