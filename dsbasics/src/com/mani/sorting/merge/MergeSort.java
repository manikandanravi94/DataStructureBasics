package com.mani.sorting.merge;
/*
merge sort usually named as divide and conquer
             best        worst
divide        O(n)         O(n)
sort           O(log n)     O(log n)
final          O(nlog n)    O(nlog n)

 */
public class MergeSort {

    public void sort(int[] a){
      //final step.. always recursion should be stopped with a condition
      if(a.length<2)
          return;

       // we have to split the array into two parts
        int middle = a.length/2;
        //assign the value to left array
        int left[] = new int[middle];
        for(int i=0;i<middle;i++)
            left[i]=a[i];
        // assign the value to right array
        int right[] = new int[a.length-middle];
        for(int j=middle;j<a.length;j++)
            right[j-middle]=a[j];
        sort(left);
        sort(right);
        merge(left,right,a);
    }

    private void merge(int[] left, int[] right, int[] a) {
        int i=0,j=0,k=0;
//compare all the elements in the right array to the left array and store it in the same input array

        while(i< left.length&&j< right.length){
            if(left[i]<=right[j]){
                a[k++]= left[i++];
            }else{
                a[k++]=right[j++];
            }
        }
        while(i< left.length)
        {
            a[k++]=left[i++];
        }
        while(j<right.length)
        {
            a[k++]=right[j++];
        }

    }

}
