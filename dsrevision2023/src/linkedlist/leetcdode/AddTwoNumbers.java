package linkedlist.leetcdode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        String k = sb.toString();
        ListNode output = new ListNode(Character.getNumericValue(k.charAt(0)));
        for (int i = 1; i < k.length(); i++) {
            ListNode temp = output;
            ListNode node = new ListNode(Character.getNumericValue(k.charAt(i)));
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        return output;
//        ListNode l1 = l1;
//        ListNode l2 = l2;
//        int size = 0;
//        while (l1 != null || l2 != null) {
//            size++;
//            l1 = l1 != null ? l1.next : null;
//            l2 = l2 != null ? l2.next : null;
//        }
//        l1 = l1;
//        l2 = l2;
//        int carry = 0;
//        ListNode output = new ListNode();
//        int outputSize = 0;
//        for (int i = 0; i < size; i++) {
//            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
//            ListNode temp = output;
//            for (int j = 0; j <= outputSize; j++) {
//                if (temp.next== null && temp.val==0) {
//                    outputSize++;
//                    temp= new ListNode((sum % 10) + carry);
//                    break;
//                }
//                temp = temp.next;
//            }
//            carry = sum / 10;
//            l1 = l1 != null ? l1.next : null;
//            l2 = l2 != null ? l2.next : null;
//            if (l1 == null && l2 == null) {
//                temp.next = new ListNode(sum % 10);
//                output = temp;
//                break;
//            }
//            output=temp;
//        }
//        return output;
    }
}
