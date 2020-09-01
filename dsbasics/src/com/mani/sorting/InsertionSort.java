package com.mani.sorting;

import java.util.Arrays;

/*
sort best : O(n)  worst: O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a ={2,6,7,1,8};

        for(int i =1;i<a.length;i++){
            int current = a[i];
            int j=i-1;
            while(j>=0 && a[j]>current){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=current;
        }
        System.out.println("Insertion sort :"+ Arrays.toString(a));
    }
}
