package array.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicateSortedArray duplicateSortedArray = new RemoveDuplicateSortedArray();
        System.out.println(duplicateSortedArray.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> distinctIntegers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!distinctIntegers.contains(nums[i])) {
                distinctIntegers.add(nums[i]);
                nums[distinctIntegers.size() - 1] = nums[i];
            }
        }
        return distinctIntegers.size();
    }
}
