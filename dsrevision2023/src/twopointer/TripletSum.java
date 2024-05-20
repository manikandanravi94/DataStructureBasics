package twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TripletSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> integerListCollection = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length ; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[j + 1]);
                        integers = integers.stream().sorted().collect(Collectors.toList());
                        if (!integerListCollection.contains(integers)) {
                            integerListCollection.add(integers);
                        }
                    }
                }
            }
        }
        return integerListCollection;
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, 4, -1, 0, 1};
        System.out.println(threeSum(input));
        int[] input2 = {-2,0,1,1,2};
        System.out.println(threeSum(input2));
    }

}
