package array.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    static int majorityElement(int[] sums){
        Map<Integer,Integer> elementCountMap = new HashMap<>();
        for(int i=0;i<sums.length;i++){
            elementCountMap.compute(sums[i],(key,count) ->{
                if(count==null){
                    count= Integer.valueOf(1);
                }
                return ++count;
            });
        }
        return elementCountMap.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }
    public static void main(String[] args) {
    int[] input = {2,2,1,1,1,4,4,4,4,5,5,5,5,5};
        System.out.println(majorityElement(input));
    }
}
