package linkedlist;

public class LinkedListImpl {

    private Node first;

    private Node last;

    private int size;


    public void addFirst(int value) {
        if (first == null) {
            Node node = new Node(value, null);
            this.first = node;
            this.last = node;
        } else {
            this.first = new Node(value, this.first);
        }
        size++;
    }

    public void addLast(int value) {
        if (last == null) {
            Node node = new Node(value, null);
            this.first = node;
            this.last = node;
        } else {
            Node node=new Node(value, null);
            this.last.node=node;
            this.last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (first.node == null) {
            this.first = null;
            this.last = null;
        } else {
            this.first = first.node;
        }
        size--;
    }

    public void deleteLast() {
        if (this.last == null) {
            return;
        }
        Node temp = this.first;
        for (int i = 0; i < size; i++) {
            if (temp.node.node == null) {
break;
            }
            temp = temp.node;
        }
        this.last = temp;
        this.last.node = null;
        size--;
    }

    public boolean contains(int value) {
        Node temp = this.first;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return true;
            }
            temp = temp.node;
        }
        return false;
    }

    public int indexOf(int value) {
        Node temp = this.first;
        for (int i = 1; i <= size; i++) {
            if (temp.value == value) {
                return i;
            }
            temp = temp.node;
        }
        return -1;
    }

    public void print() {
        StringBuilder listPrint = new StringBuilder("[");
        Node temp = this.first;
        for (int i = 0; i < size; i++) {
            listPrint.append(temp.value);
            temp = temp.node;
            if (i < size - 1) {
                listPrint.append(",");
            }
        }
        listPrint.append("]");
        System.out.println(listPrint);
    }

    /*
    Reverse a linked list
     */
    public void reverse(){
       Node previous=first;
       Node current=first.node;
       while(current!=null){
           Node next=current.node;
           current.node=previous;
           previous=current;
           current=next;
       }
       this.last=first;
       this.last.node=null;
       this.first=previous;
    }
//    public void reverse(){
//       Node temp = this.first;
//       this.first=null;
//       this.last=null;
//       for(int i=0;i<size;i++){
//           Node secondaryTemp= temp;
//           if(secondaryTemp.node==null){
//               addLast(secondaryTemp.value);
//               size--;
//               break;
//           }
//           while(secondaryTemp.node.node!=null){
//               secondaryTemp=secondaryTemp.node;
//           }
//           addLast(secondaryTemp.node.value);
//           size--;
//           secondaryTemp.node=null;
//       }
//    }

    /*
    kth element
     */
    public int kthElement(int index){
        if(size<=0||index>size)
            return -1;
        Node current=this.first;
        for(int i=0;i<size-index;i++){
            current=current.node;
        }
        return current.value;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addFirst(60);
        linkedList.addFirst(70);
        linkedList.addFirst(80);
        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.print();
        linkedList.reverse();
        linkedList.print();
        System.out.println(linkedList.kthElement(2));
        System.out.println(linkedList.kthElement(1));
    }

}
