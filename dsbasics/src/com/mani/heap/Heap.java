package com.mani.heap;

import java.util.Arrays;

public class Heap {

    private int[] heapArray = new int[10];

    private int size;

    public Heap() {
    }

    public void insert(int element) {
        heapArray[size++] = element;
        bubbleUp();
        System.out.println(Arrays.toString(heapArray));
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && heapArray[index] > heapArray[parentIndex(index)]) {
            int temp = heapArray[index];
            heapArray[index] = heapArray[parentIndex(index)];
            heapArray[parentIndex(index)] = temp;
            index = parentIndex(index);
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int temp = heapArray[0];
        heapArray[0] = heapArray[--size];
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = getLargerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
        return temp;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return heapArray[index] >= heapArray[leftChildIndex(index)];

        return heapArray[index] >= heapArray[leftChildIndex(index)] &&
                heapArray[index] >= heapArray[rightChildIndex(index)];
    }

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);

        return heapArray[leftChildIndex(index)] > heapArray[rightChildIndex(index)]
                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void swap(int index, int largerChildIndex) {
        int temp = heapArray[index];
        heapArray[index] = heapArray[largerChildIndex];
        heapArray[largerChildIndex] = temp;
    }

    public void heapify(int[] inputArray){
       int lastParentIndex=(inputArray.length/2)-1;
       for(int i=lastParentIndex;i>=0;i--){
           heapify(inputArray, i);
       }
    }

    private void heapify(int[] inputArray, int index) {
        int largerChildIndex=index;
        int leftChildIndex= (index*2)+1;
        if(leftChildIndex< inputArray.length&&inputArray[leftChildIndex]>= inputArray[index])
            largerChildIndex=leftChildIndex;
        int rightChildIndex= (index*2)+2;
        if(rightChildIndex< inputArray.length&&inputArray[rightChildIndex]>= inputArray[index])
            largerChildIndex=rightChildIndex;
        if(index==largerChildIndex)
            return;
        swap(inputArray,index,largerChildIndex);
        heapify(inputArray,largerChildIndex);
        System.out.println("heapify array :"+Arrays.toString(inputArray));
    }

    private void swap(int[] inputArray, int index, int largerChildIndex) {
        int temp=inputArray[index];
        inputArray[index]=inputArray[largerChildIndex];
        inputArray[largerChildIndex]=temp;
    }

    public void printHeap() {
        System.out.println("size of the array" + size);
        System.out.println(Arrays.toString(heapArray));
    }
}
