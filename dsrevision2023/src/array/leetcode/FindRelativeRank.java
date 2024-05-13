package array.leetcode;

import hashmap.Entry;

import java.util.*;
import java.util.stream.Collectors;

public class FindRelativeRank {

    public static String[] findRelativeRanks(int[] score) {
        String[] output = new String[score.length];
        Map<Integer, Integer> inputMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            inputMap.put(score[i], i);
        }
        Map<Integer, String> prizeMap = new HashMap<>();
        prizeMap.put(1, "Gold Medal");
        prizeMap.put(2, "Silver Medal");
        prizeMap.put(3, "Bronze Medal");
        List<Integer> entries = inputMap.entrySet().stream().sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey())).map(entry -> entry.getValue()).collect(Collectors.toList());
        for (int i = 0; i < entries.size(); i++) {
            if (i <= 2) {
                output[entries.get(i)]= prizeMap.get(i+1);
            } else {
                output[entries.get(i)]= String.valueOf(i+1);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
