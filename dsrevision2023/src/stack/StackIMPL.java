package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackIMPL {

    private int[] elements;

    private int size;

    private int currentSize;

    StackIMPL(int size){
        this.size=size;
        this.elements=new int[size];
    }

    public void push(int element){
        elements[currentSize]=element;
        currentSize++;
    }

    public Integer pop(){
        if(!this.empty()){
            return -1;
        }else{
            currentSize--;
            int temp=elements[currentSize];
            elements[currentSize]=0;
            return temp;
        }
    }

    public boolean empty(){
        if(currentSize>0){
            return true;
        }else{
            return false;
        }
    }

    public void print(){
        System.out.println(Arrays.toString(elements));
    }


    public static void main(String[] args) {
        StackIMPL stackIMPL = new StackIMPL(5);
        stackIMPL.push(1);
        stackIMPL.push(2);
        stackIMPL.push(3);
        stackIMPL.push(4);
        stackIMPL.push(5);
        stackIMPL.print();
        System.out.println(stackIMPL.pop());
        stackIMPL.print();
        stackIMPL.reverse();
        System.out.println(stackIMPL.validParenthesis("[]{()"));
    }

    public static Map<Character, Integer> OPEN_BRACKET_MAP = new HashMap<>();

    public static Map<Character, Integer> CLOSE_BRACKET_MAP = new HashMap<>();

    static {
        OPEN_BRACKET_MAP.put('(', 1);
        CLOSE_BRACKET_MAP.put(')', 1);
        OPEN_BRACKET_MAP.put('[', 2);
        CLOSE_BRACKET_MAP.put(']', 2);
        OPEN_BRACKET_MAP.put('{', 3);
        CLOSE_BRACKET_MAP.put('}', 3);
    }

    public boolean validParenthesis(String pattern) {
        Stack<Character> characterStack = new Stack<>();
        for (char ch : pattern.toCharArray()) {
            if (OPEN_BRACKET_MAP.containsKey(ch)) {
                characterStack.push(ch);
            } else {
                int previousBracketValue = OPEN_BRACKET_MAP.getOrDefault(characterStack.empty() ? 0 : characterStack.pop(), 0);
                if (CLOSE_BRACKET_MAP.get(ch) != previousBracketValue) {
                    return false;
                }
            }
        }
        if (characterStack.empty())
            return true;
        else
            return false;
    }

    public void reverse() {
        //Reverse a strting
        String k = "abcd";
        Stack<Character> stack = new Stack<>();
        for (char ch : k.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
