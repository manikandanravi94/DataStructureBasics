package array.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindSpecialInteger {

    public static int findSpecialInteger(int[] arr) {
        Map<Integer,Integer> intCountMap = new HashMap();
        for(int i=0;i<arr.length;i++){
            Integer key = arr[i];
            if(intCountMap.containsKey(key)){
                intCountMap.put(key,intCountMap.get(key)+1);
            }else{
                intCountMap.put(key,1);
            }
        }
       Map.Entry<Integer,Integer> maxValueEntry= intCountMap.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        return maxValueEntry.getKey();
    }

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println(findSpecialInteger(new int[]{1,1}));
    }
}
