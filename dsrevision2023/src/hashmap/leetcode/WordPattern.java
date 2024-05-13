package hashmap.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> charMap = new HashMap<>();
        String[] k=s.split(" ");
        if(pattern.length() != k.length){
            return false;
        }
        Set<String> uniqueWord = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(charMap.containsKey(ch)){
                if(!charMap.get(ch).equals(k[i])){
                    return false;
                }
            }else{
                charMap.put(ch,k[i]);
                if(uniqueWord.contains(k[i])){
                    return false;
                }else{
                    uniqueWord.add(k[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }
}
