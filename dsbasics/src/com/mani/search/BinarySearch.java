package com.mani.search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("index of the given value:"+findElement(25));
    }

    private static int findElement(int element) {
        int[] arrayInput = {1,3,4,5,6,8,10,12,15,20};
        return findElementInArray(arrayInput,element, 0, arrayInput.length-1);
    }

    private static int findElementInArray(int[] arrayInput, int element, int start, int end) {
        if(start<end)
            return -1;
        if(arrayInput[start]==element)
            return start;
        int middle = (start+end)/2;
        if(arrayInput[middle]<=element){
            start=middle;
        }else{
            end=middle;
        }
        return findElementInArray(arrayInput,element,start,end);
    }
}
