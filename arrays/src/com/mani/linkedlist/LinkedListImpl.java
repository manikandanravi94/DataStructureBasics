package com.mani.linkedlist;

/**
 * Created by gbs05347 on 10-04-2020.
 * time complexity of lookup of an element o(n)
 * insert, delete an element at first o(1)
 * insert element at last o(1)
 * delete element at last o(n)
 * insert element in the middle o(n)
 */
public class LinkedListImpl {

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {
        Node node = new Node();
        if (first != null) {
            node.setValue(value);
            node.setNext(first);
            first = node;
        } else {
            last = node;
            last.setValue(value);
            first = node;
            first.setValue(value);
            //  first.setNext(last);
        }
        size++;
    }

    public void addLast(int value) {
        Node node = new Node();
        if (last == null) {
            node.setValue(value);
            last = node;
            first = node;
        } else {
            node.setValue(value);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    public void print() {
        Node temp = first;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(temp.getValue());
            temp = temp.getNext();
            if (temp != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public boolean contains(int element) {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.getValue() == element) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public Integer indexOf(int element) {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.getValue() == element) {
                return i + 1;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void deleteFirst(){
        if(first!=null){
            if(first.getNext()==null){
                first=null;
            }else{
                first=first.getNext();
            }
        }
        size--;
    }

    public void deleteLast(){
        Node temp=first;
        for(int i=0;i<size;i++){
            if(first.getNext()==last){
                first.setNext(null);
                size--;
            }
            first=first.getNext();
        }
        first=temp;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addLast(60);
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addFirst(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.print();
        System.out.println(linkedList.contains(30));
        System.out.println(linkedList.indexOf(40));
        linkedList.deleteFirst();
        linkedList.deleteFirst();
        linkedList.print();
        linkedList.deleteLast();
        linkedList.print();
    }
}
