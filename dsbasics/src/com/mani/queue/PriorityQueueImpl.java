package com.mani.queue;

import java.util.Arrays;

/**
 * Created by gbs05347 on 26-04-2020.
 * Normally priority queue arranges the element in the ascending order. so we need to arrange the element in the ascending order
 * thats the main logic of priority queue
 * insert,retrieve,delete a element o(n)
 */
public class PriorityQueueImpl {

   private int[] queue;
   private int size=0;


    private void enqueue(int element) {
        if (size == 0) {
            queue = new int[++size];
            queue[0] = element;
            ;
        } else {
            int oldCapacity = size;
            queue = Arrays.copyOf(queue, ++size);
            for (int i = oldCapacity - 1; i >= 0; i--) {
                if (element < queue[i]) {
                    queue[i + 1] = queue[i];
                    queue[i] = element;
                } else {
                    queue[i + 1] = element;
                    break;
                }
            }
        }
    }

      private void print(){
        System.out.println(Arrays.toString(queue));
    }


    public static void main(String[] args) {
        PriorityQueueImpl priorityQueue= new PriorityQueueImpl();
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(11);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(11);
        priorityQueue.print();
    }
}
