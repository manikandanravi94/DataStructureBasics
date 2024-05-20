package dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    public static int fib(int n){
        if(n<=1){
            dpArray[n]=n;
            return n;
        }
        if(dpArray[n]!=0){
            return dpArray[n];
        }

        return dpArray[n]=fib(n-1)+fib(n-2);
    }

    public static int[] dpArray;

    public static void main(String[] args) {
        int input = 8;
        dpArray=new int[input+1];

        System.out.println(fib(input));
        System.out.println(Arrays.toString(dpArray));
    }
}
