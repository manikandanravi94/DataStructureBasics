package linkedlist.leetcdode;

public class MergeTwoList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null || temp1.val==0) {
                temp1 = temp2;
                break;
            }
            if(temp2==null){
                break;
            }
            if (temp2.val == temp1.val) {
                ListNode temp = temp1.next;
                temp1.next = new ListNode(temp2.val, temp);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }else if(temp2.val > temp1.val && temp2.val<temp1.next.val ) {
                ListNode temp = temp1.next;
                temp1.next = new ListNode(temp2.val, temp);
                temp2 = temp2.next;
            }
            else {
                temp1=temp1.next;
            }


        }
        return list1;
    }


    public static void main(String[] args) {
        ListNode input1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode input2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode output = mergeTwoLists(input1,input2);
        ListNode input3 = new ListNode();
        ListNode input4 = new ListNode(0);
        ListNode output1 = mergeTwoLists(input3,input4);
        System.out.println(output.toString());
    }
}
