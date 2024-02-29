package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueIMPL {

    int[] arrayQueue = new int[5];

    int first=0;

    int last=0;

    public void enqueue(int val){
        if(last-first==5){
            return;
        }
        arrayQueue[last%5]=val;
        last++;
    }

    public void dequeue(){
        if(first==last){
            first=0;
            last=0;
            return;
        }
        first++;
    }

    public int peek(){
        if(first==last){
            return -1;
        }
        return arrayQueue[first];
    }

    public boolean isEmpty(){
        return first==last;
    }

    public boolean isFull(){
        return last==5;
    }

    public void print(){
        StringBuilder sb = new StringBuilder("[");
        for(int i=first;i<last;i++){
            sb.append(arrayQueue[i%5]).append(",");
        }
        sb.append("]");
        System.out.println(sb.toString().replace(",]","]"));
    }

    public static void main(String[] args) {
        QueueIMPL queueIMPL = new QueueIMPL();
        queueIMPL.enqueue(10);
        queueIMPL.enqueue(20);
        queueIMPL.enqueue(30);
        queueIMPL.enqueue(40);
        queueIMPL.enqueue(50);
        System.out.println(queueIMPL.isEmpty());
        queueIMPL.print();
        System.out.println(queueIMPL.peek());
        queueIMPL.dequeue();
        queueIMPL.dequeue();
        queueIMPL.dequeue();
        queueIMPL.dequeue();
        queueIMPL.enqueue(60);
        queueIMPL.enqueue(70);
        queueIMPL.enqueue(80);
        queueIMPL.enqueue(90);
        queueIMPL.dequeue();
        queueIMPL.enqueue(100);
        System.out.println("first index : "+queueIMPL.first);
        System.out.println("last index : "+queueIMPL.last);
        queueIMPL.print();
        //Queue Exercises
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);
    }

    /*
    Queue problem 1
     */
    private static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        queue.stream().forEach(stack::push);
        queue.clear();
        while(!stack.empty()){
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }
}
