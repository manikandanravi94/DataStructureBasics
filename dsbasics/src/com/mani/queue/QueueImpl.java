package com.mani.queue;

import java.util.Arrays;

/**
 * Created by gbs05347 on 19-04-2020.
 */
public class QueueImpl {

    private int[] array;
    private int size=0;
    private int first=0;
    private int last=0;

    private void enqueue(int element){
        if(size==0){
            array=new int[1];
            array[0]=element;
            size=1;
        }else{
        array=Arrays.copyOf(array, ++size);
        array[size-1]=element;
        last=size;}
    }

    private int dequeue(){
        first++;
        --size;
        return array[first-1];
    }

    private void customPrint(){
        System.out.print("[");
        for(int i=first;i<last;i++){
            System.out.print(array[i]);
            if(last>1&&i!=last-1){
                System.out.print(",");}
        }
        System.out.print("]");
    }

    private void peek(){
        System.out.println(array[first]);
    }

    private void print(){
        System.out.println(Arrays.toString(array));
    }

    private boolean isEmpty(){
       return (size==0);
    }

    public static void main(String[] args) {
    QueueImpl queue= new QueueImpl();
    queue.enqueue(10);
    queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
    queue.print();
    queue.isEmpty();
    queue.dequeue();
        queue.dequeue();
    queue.customPrint();
    queue.peek();
    }
}
