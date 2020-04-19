package com.mani.array;

import java.util.Arrays;

/*
lookup of an element o(1)
insert,delete an element o(n)
Arrays are easy for retrival but time complexity s more while inserting and deleting
*/
public class ArrayImplementation{

     private int[] array;

     private int size;

     private int index;

    private ArrayImplementation(int size){
        this.size=size;
        this.array=new int[size];
    }

   private void print(){
        System.out.println(Arrays.toString(this.array));
        System.out.println(index);
    }

   private void insert(int element){
        if(this.index==this.array.length){
            int[] tempArray=this.array;
            size++;
            this.array=new int[size];
            for(int i=0;i<tempArray.length;i++){
                this.array[i]=tempArray[i];
            }
            this.array[index]=element;
            index++;
        }
        else{
            System.out.println(this.array.length);
            this.array[index]=element;
            index++;
        }
    }

   private void remove(int element){
        for(int i=0;i<size;i++){
            if(array[i]==element)
            {
                int j=i;
                while(j<size){
                 array[j]=array[++j];
                 array[j]=0;
                 if(j<=size-1) {
                     i=0;
                 break;
                 }
                 System.out.println("index of array "+j+" value: "+Arrays.toString(this.array));
             }
            }
        }
        System.out.println(Arrays.toString(this.array));
    }

   private void indexOf(int value){
     for(int i=0;i<size;i++){
         if(array[i]==value)
         {
             System.out.println("index of an element in an array: "+i);
         }
     }
    }

    public static void main(String[] args) {
        ArrayImplementation arr = new ArrayImplementation(3);
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.insert(40);
        arr.print();
        arr.indexOf(40);
        arr.remove(40);
    }
}