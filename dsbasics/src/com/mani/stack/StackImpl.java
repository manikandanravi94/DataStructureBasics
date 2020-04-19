package com.mani.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by gbs05347 on 12-04-2020.
 */
public class StackImpl {

    private int[] stackArray;

    private int size;

    private void push(int element){
        if(size==0){
            stackArray= new int[++size];
            stackArray[0]=element;
        }else{
            int[] tempArray=stackArray;
            stackArray= new int[++size];
            for(int i=0;i<tempArray.length;i++){
                stackArray[i]=tempArray[i];
            }
            stackArray[size-1]=element;
        }
    }

    private int pop(){
        if(size==0)
            return 0;
        int[] tempArray=stackArray;
        stackArray=new int[--size];
        for(int i=0;i<size;i++){
            stackArray[i]=tempArray[i];
        }
        return tempArray[size];
    }

    private boolean isEmpty(){
        return size!=0;
    }

    private int peek(){
        if(size==0)
            throw new IllegalArgumentException();
        return stackArray[size-1];
    }

    private void print(){
        System.out.println(Arrays.toString(stackArray));
    }

    /* task1
    reverse a string
    */
    private String reverseString(String s){
        char[] forwardString=s.toCharArray();
        Stack<String> stringStack = new Stack<>();
        for(char c:forwardString){
            stringStack.push(String.valueOf(c));
        }
        StringBuilder reverseString = new StringBuilder();
        int tempSize=stringStack.size();
        for(int i=0;i<tempSize;i++){
            reverseString.append(stringStack.pop());
        }
        return reverseString.toString();
    }

    /* Task 2
    Balanced brackets in a string
     */
    private boolean balancedBrackets(String string){
        boolean flag=false;
        char[] openBrackets={'{','['};
        char[] closeBrackets={'}',']'};
        Stack<Character> stack = new Stack<>();
        for(char c:string.toCharArray()){
            for(char k: openBrackets){
            if(k==c){
                stack.push(c);
            }}
                for(int i=0;i<closeBrackets.length;i++){
                    if(closeBrackets[i]==c){
                        if (stack.empty())
                        {
                            return false;
                        }
                        if(openBrackets[i]==stack.pop())
                        {
                            flag= true;
                        }
                        else{
                            flag= false;
                        }
                }
            }
        }
        if(!stack.empty()){
            flag=false;
        }
        return flag;
    }

    public static void main(String[] args) {
        String s="abcd";
       StackImpl stack=new StackImpl();
        System.out.println(stack.reverseString(s));
        System.out.println(stack.balancedBrackets("}[1]{"));
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
