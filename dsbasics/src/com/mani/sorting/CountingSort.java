package com.mani.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = {2,6,7,1,8};
        //always count array value should be max value +1 because when index starts from 0 it vl end upto 7
        //if we directly assign the max
        int[] countArray = new int[9];
        for(int i=0;i< array.length;i++)
        {
            countArray[array[i]]++;
        }

        int k=0;
        for(int i=0;i< countArray.length;i++){
            for(int j=0;j<countArray[i];j++){
                array[k++]=i;
            }
        }

        System.out.println("sorted array value :"+ Arrays.toString(array));
    }
}
