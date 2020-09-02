package com.mani.sorting;

import java.util.Arrays;

/*
sort best : O(n)  worst: O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a ={2,6,7,1,8};
/* we have to start checking from index of 1 because there is no use of checking 0th index element as it dont
 have any previous element.. while comparing the previous element if it tends to be bigger than the current element
 we have to shift the element to its next index.. and finally copy the current element into older index of the
 swapped element
 */
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
