package com.mani.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gbs05347 on 26-07-2020.
 */
public class SetImpl {

    public static void findFirstRepeatedCharacter(String s){
        char[] charArray = s.toCharArray();
        Set<Character> charSet= new HashSet<>();
        for(int i=0;i<charArray.length;i++){
            if(charSet.contains(charArray[i]))
            {
                System.out.println(charArray[i]);
                break;
            }else{
            charSet.add(charArray[i]);}
        }
    }

    public static void main(String[] args) {
        SetImpl.findFirstRepeatedCharacter("green apple");
    }
}
