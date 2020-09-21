package com.mani.stringmanipulation;

import java.util.*;
import java.util.stream.Collectors;

public class StringUtil {


    public static void findVowelCount(String s) {
        int count = 0;
        if (s != null) {
            char[] chars = s.toLowerCase().toCharArray();
            for (char c : chars)
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    count++;
        }
        System.out.println("vowel count :" + count);
    }

    public static void stringReverse(String s) {
        StringBuffer sb = new StringBuffer();
        if (s != null) {
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println("Reversed string :" + sb.toString());
    }

    public static void reverseWord(String s) {
        if (s != null) {
            String[] strings = s.split(" ");
            //filter has been added for my reference
            List<String> words = Arrays.stream(strings).filter(s1 -> !s1.isEmpty()).collect(Collectors.toList());
            System.out.println(words.toString());
            // string tokenizer usage is not recommended
//            StringTokenizer stringTokenizer = new StringTokenizer(s," ");
//            while(stringTokenizer.hasMoreElements()){
//                words.add(stringTokenizer.nextToken());
//            }
            StringBuilder sb = new StringBuilder();
            for (int i = words.size() - 1; i >= 0; i--) {
                sb.append(words.get(i));
                if (i > 0) {
                    sb.append(" ");
                }
            }
            System.out.println("reverse a word :" + sb.toString());
        }
    }

    public static void removeDuplicateChars(String s) {
        if (s != null) {
            StringBuilder sb = new StringBuilder();
            Set<Character> seen = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (!seen.contains(c)) {
                    seen.add(c);
                    sb.append(c);
                }
            }
            System.out.println("Duplicate removed string : " + sb.toString());
        }
        //my solution added extra list
//            Set<Character> characterSet = new LinkedHashSet<>();
//            for(int i= 0;i<=s.length()-1;i++){
//                characterSet.add(s.charAt(i));
//            }
//            StringBuilder sb = new StringBuilder();
//            new ArrayList<>(characterSet).forEach(sb::append);
//            System.out.println("Removed duplicate charactes : "+sb.toString());
    }

    public static void areRotational(String s1, String s2){
        if(s1.isEmpty()||s2.isEmpty())
            return;
        boolean rotate = (s1.length()==s2.length())&&(s1+s1).contains(s2);
        System.out.println("Does both strings rotatable :"+rotate);
    }

    public static void mostRepeated(String s) {
        Map<Character, Integer> repeatCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (repeatCountMap.containsKey(c)) {
                repeatCountMap.put(c, repeatCountMap.get(c) + 1);
            } else {
                repeatCountMap.put(c, 1);
            }
        }
        int maxCount = repeatCountMap.values().stream().max(Integer::compareTo).get();
        for (Map.Entry entry : repeatCountMap.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                System.out.println("Most repeated character :" + entry.getKey());
                break;
            }
        }
    }

    public static void firstLetterCaps(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        List<String> stringList = Arrays.stream(strings).filter(s1 -> !s1.isEmpty()).collect(Collectors.toList());
        for (int i = 0; i < stringList.size(); i++) {
            String word = stringList.get(i);
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
            if (i <= stringList.size() - 1)
                sb.append(" ");
        }
        System.out.println("First Letter caps: " + sb.toString());
    }

    public static void anagramUsingArray(String s1, String s2) {
        char[] c1 = s1.toLowerCase().trim().toCharArray();
        //it uses quick sort and hence time complexity is  O(n log n)
        Arrays.sort(c1);
        char[] c2 = s2.toLowerCase().trim().toCharArray();
        Arrays.sort(c2);
        if (Arrays.equals(c1, c2))
            System.out.println("Given strings are anagram");
        else
            System.out.println("Given strings are not anagram");
    }

    public static void palindrome(String s){
        if(s.isEmpty()){
            System.out.println("Given string is not a palindrome");
        return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0;i--){
            sb.append(s.toLowerCase().charAt(i));
        }
         if(s.toLowerCase().equals(sb.toString())) {
             System.out.println("Given string is a palindrome");
         }else{
             System.out.println("Given string is not a palindrome");
         }
    }

    //my solution more time complexity
    public static void anagramUsingMap(String s1, String s2) {
        Map<Character, Integer> char1Map = new HashMap<>();
        Map<Character, Integer> char2Map = new HashMap<>();
        for (char c : s1.trim().toCharArray()) {
            if (char1Map.containsKey(c))
                char1Map.put(c, char1Map.get(c) + 1);
            else
                char1Map.put(c, 1);
        }
        for (char c : s2.trim().toCharArray()) {
            if (char2Map.containsKey(c))
                char2Map.put(c, char2Map.get(c) + 1);
            else
                char2Map.put(c, 1);
        }
        for (char c : s1.trim().toCharArray()) {
            if (!char1Map.containsKey(c) || !char2Map.containsKey(c) || !char1Map.get(c).equals(char2Map.get(c))) {
                System.out.println("Given two string are not anagram");
                return;
            }
        }
        System.out.println("Given two strings are anagram");
    }


}
