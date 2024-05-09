package array.leetcode;

public class LargestPositiveInteger {

    public static int findMaxK(int[] nums) {
        int max=-1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==0 && Math.abs(nums[i])>max){
                    max=Math.abs(nums[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1,2,-3,3}));
    }
}
