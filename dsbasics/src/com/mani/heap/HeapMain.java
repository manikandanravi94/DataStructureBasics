package com.mani.heap;

import java.util.Arrays;

public class HeapMain {
    public static void main(String[] args) {

        Heap heap = new Heap();
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(100);
        heap.remove();

        //heap sort
        int[] numbers = new int[]{5,3,8,4,6,9};
        Heap heapDesSort = new Heap();
        for(int i=0;i< numbers.length;i++){
            heapDesSort.insert(numbers[i]);
        }
        // when we want descending order
        int[] descendingOrder = new int[numbers.length];
        for(int i=0;i< numbers.length;i++){
            descendingOrder[i]=heapDesSort.remove();
        }
        System.out.println("Descending order :"+ Arrays.toString(descendingOrder));


        Heap heapAscSort = new Heap();
        for(int i=0;i< numbers.length;i++){
            heapAscSort.insert(numbers[i]);
        }
        int[] ascendingOrder = new int[numbers.length];
        for(int i= numbers.length-1;i>=0;i--){
            ascendingOrder[i]=heapAscSort.remove();
        }
        System.out.println("ascending order :"+ Arrays.toString(ascendingOrder));

        heap.printHeap();
        heap.heapify(new int[]{5,3,8,4,6,9});
    }
}
