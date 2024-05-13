package hashmap.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Isomorphic {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> inputMap = new LinkedHashMap<>();
        Map<Character, List<Integer>> outputMap = new LinkedHashMap();
        for(int i=0;i<s.length();i++){
            char inputChar = s.charAt(i);
            if(inputMap.containsKey(inputChar)){
                inputMap.get(inputChar).add(i);
            }else{
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                inputMap.put(inputChar, indexes);
            }
            char outputChar = t.charAt(i);
            if(outputMap.containsKey(outputChar)){
                outputMap.get(outputChar).add(i);
            }else{
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                outputMap.put(outputChar, indexes);
            }
        }
        List<List<Integer>> inputList =inputMap.values().stream().collect(Collectors.toList());
        List<List<Integer>> outputList =outputMap.values().stream().collect(Collectors.toList());
        for(int i=0;i<inputList.size();i++){
            if(!inputList.get(i).equals(outputList.get(i))){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("paper","title"));
    }
}
