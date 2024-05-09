package linkedlist.leetcdode;

import java.math.BigInteger;

public class DoubleNumber {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode doubleIt(ListNode head) {
        ListNode outputNode = new ListNode();
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp!=null){
            sb.append(temp.val);
            temp=temp.next;
        }
        BigInteger outputBig = new BigInteger(sb.toString());
        String output = outputBig.multiply(BigInteger.valueOf(2)).toString();
        System.out.println();
        outputNode = new ListNode(Character.getNumericValue(output.charAt(0)));
        for(int i=1;i<output.length();i++){
            temp=outputNode;
            ListNode newNode = new ListNode(Character.getNumericValue(output.charAt(i)));
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
        System.out.println(outputNode);
        return outputNode;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1, new ListNode(8,new ListNode(9)));
        System.out.println(doubleIt(input).toString());
        int[] input1 = new int[]{9,1,9,5,0,5,1,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        ListNode inputBig = new ListNode(input1[0]);

        for(int i=1;i<input1.length;i++){
            ListNode temp =inputBig;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new ListNode(input1[1]);
        }

        System.out.println(doubleIt(inputBig).toString());
    }
}
