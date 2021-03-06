package com.mani.sorting;

import java.util.Arrays;

/*
sort O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array2Sort ={2,6,7,1,8};
//first consider oth element as the lowest value and start iterating the array and compare all the elements
// replace the lowest value in the array to the current lowest value and store it in the older array.
        for(int i=0;i< array2Sort.length;i++){
            int lowest_value = array2Sort[i];
            int index=i;
            for(int j=i+1;j< array2Sort.length-1;j++){
                if(array2Sort[j]<=lowest_value){
                  lowest_value = array2Sort[j];
                  index=j;
                }
                int temp=array2Sort[i];
                array2Sort[i]=array2Sort[index];
                array2Sort[index]=temp;
                System.out.println(Arrays.toString(array2Sort));
            }

        }
        System.out.println("Selection Sorted array :"+ Arrays.toString(array2Sort));
    }
}
