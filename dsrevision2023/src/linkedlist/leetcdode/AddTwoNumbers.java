package linkedlist.leetcdode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2= new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l3=addTwoNumbers.addTwoNumbers(l1, l2);
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int size = 0;
        while (temp1 != null || temp2 != null) {
            size++;
            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
        }
        temp1 = l1;
        temp2 = l2;
        int carry = 0;
        ListNode output = new ListNode();
        int outputSize = 0;
        for (int i = 0; i < size; i++) {
            int sum = (temp1 != null ? temp1.val : 0) + (temp2 != null ? temp2.val : 0);
            ListNode temp = output;
            for (int j = 0; j <= outputSize; j++) {
                if (temp.next== null && temp.val==0) {
                    outputSize++;
                    temp= new ListNode((sum % 10) + carry);
                    break;
                }
                temp = temp.next;
            }
            carry = sum / 10;
            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
            if (temp1 == null && temp2 == null) {
                temp.next = new ListNode(sum % 10);
                output = temp;
                break;
            }
            output=temp;
        }
        return output;
    }
}
