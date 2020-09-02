package com.mani.sorting.merge;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] a ={2,6,7,1,8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
