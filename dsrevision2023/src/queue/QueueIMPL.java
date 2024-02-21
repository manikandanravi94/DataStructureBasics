package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueIMPL {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);
    }

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
