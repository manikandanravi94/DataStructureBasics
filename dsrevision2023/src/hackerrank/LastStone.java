package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LastStone {

    static int lastStoneWeight(List<Integer> stones) {
        int remainingWeight = 0;
        int i = stones.size() - 1;
        while (i >=0) {
            remainingWeight = remainingWeight == 0 ? Math.abs(Math.subtractExact(stones.get(i), stones.get(i - 1))) : Math.abs(Math.subtractExact(stones.get(i), remainingWeight));
            if(i==1){
                i=i-1;
            }else{
           i=i-2;}
        }
        return remainingWeight;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 4, 5);
        List<Integer> input1 = Arrays.asList(1, 2, 3, 6, 7, 7);
        Collections.sort(input);
        System.out.println(input);
        System.out.println(Math.abs(Math.subtractExact(3, 6)));
        System.out.println(lastStoneWeight(input));
        System.out.println(lastStoneWeight(input1));
    }
}
