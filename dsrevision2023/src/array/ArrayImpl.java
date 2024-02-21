package array;

import java.util.Arrays;

public class ArrayImpl {

    private int[] integers;

    private int size;

    private int currentIndex = 0;

    public ArrayImpl(int size) {
        this.size = size;
        this.integers = new int[size];
    }

    public void insert(int element) {
        if (currentIndex == size) {
            size = size + (size / 2);
            int[] tempArray = new int[size];
            for (int i = 0; i < integers.length; i++) {
                tempArray[i] = integers[i];
            }
            integers = tempArray;
        }
        integers[currentIndex] = element;
        currentIndex++;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (integers[i] == value)
                return i;
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index > this.size) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (i >= index) {
                if (i == size-1)
                {
                    integers[i]=0;
                    break;
                }
                integers[i] = integers[i + 1];
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(integers));
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.print();
        System.out.println(array.indexOf(40));
        array.removeAt(1);
        array.print();
    }
}
