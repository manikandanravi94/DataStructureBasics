package com.mani.sorting.quick;

/*             best      worst
partitioning    O(n)       O(n)
# of times      O(log n)    O(n)
total           O(nlog n)    O(n^2)
space           O(log n)     O(n)
 */
public class QuickSort {

    public void sort(int[] array, int start, int end){
        if(start>=end)
            return;
        //parition
        int boundary = partition(array,start,end);

        //sort(left)
        sort(array, start,boundary-1);
        //sort right
        sort(array,boundary+1,end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int boundary=start-1;
        for(int i=start;i<=end;i++){
            if(array[i]<=pivot){
                boundary++;
                swap(array,i,boundary);
            }
        }
        return boundary;
    }

    private void swap(int[] array, int i, int boundary) {
        int temp=array[i];
        array[i]=array[boundary];
        array[boundary]=temp;
    }
}
