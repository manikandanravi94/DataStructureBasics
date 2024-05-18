package linkedlist.leetcdode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateList {

    private static int size = 0;

    private static Queue<Integer> q = new LinkedList<>();

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode output = new ListNode();
        ListNode temp = head;

        while (temp != null) {
            size++;
            q.offer(temp.val);
            temp = temp.next;
        }
        if(q.size()==0 || k==0){
            return head;
        }
        int rotate = k % q.size();
        if (size == rotate || rotate==0) {
            return head;
        }
        for (int i = 0; i <= rotate; i++) {
            int tempVal = q.poll();
            q.offer(tempVal);
        }
        temp = output;
        while (q.iterator().hasNext()) {
            temp.val = q.poll();
            if(q.iterator().hasNext())
                temp.next= new ListNode();
            temp = temp.next;
        }
        return output;
    }


    public static void main(String[] args) {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(RotateList.rotateRight(input, 2));
        ListNode input1 = new ListNode(1);
        System.out.println(RotateList.rotateRight(input1,1));
    }


}
