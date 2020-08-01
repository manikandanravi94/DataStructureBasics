package com.mani.queue;

import java.util.Arrays;

/**
 * Created by gbs05347 on 19-04-2020.
 */
public class CircularQueueImpl {

    private int[] array;
    private int size;
    private int first;
    private int last;

    CircularQueueImpl(int capacity){
        size=capacity;
        array= new int[size];
    }

    private void enqueue(int element){
        first=last%size;
        if(array[first]==0){
        array[first]=element;
        }
        else{
            throw new IllegalStateException("queue is full, remove element to store newer one");
        }
        last++;
    }

    private int dequeue(){
        first=last%size;
        int temp=array[first+1];
        array[first]=0;
        return temp;
    }

    private void peek(){
        System.out.println(array[first+1]);
    }


    private void print(){
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        CircularQueueImpl queue = new CircularQueueImpl(5);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        queue.enqueue(50);
        queue.dequeue();
        queue.enqueue(60);
        queue.dequeue();
        queue.enqueue(80);
        queue.print();
        queue.peek();

    }
}
