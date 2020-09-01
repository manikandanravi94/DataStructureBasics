package com.mani.sorting;

import java.util.Arrays;

/*
sort an element O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array2Sort ={2,6,7,1,8};

        for(int i=0;i< array2Sort.length;i++){
            for(int j=0;j< array2Sort.length-1;j++){
                if(array2Sort[j]>=array2Sort[j+1]){
                    int temp = array2Sort[j];
                    array2Sort[j]=array2Sort[j+1];
                    array2Sort[j+1]=temp;
                }
            }
        }
        System.out.println("Bubble Sorted array :"+ Arrays.toString(array2Sort));
    }
}
