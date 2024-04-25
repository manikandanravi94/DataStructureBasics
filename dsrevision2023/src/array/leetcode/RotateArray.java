package array.leetcode;

import java.util.Arrays;

public class RotateArray {
        public static void rotate(int[] nums, int k) {
            int[] output = new int[nums.length];
            int j=0;
            int size=nums.length;
            if(nums.length<=1){
                return;
            }
            for(int i =0;i<size;i++){
                if(i<=k && k%2!=0 && k!=1){
                    output[k+i]=nums[i];
                }else if(i<k &&( k%2==0|| k==1)){
                    output[k+i]=nums[i];
                }
                else{
                    output[j]=nums[i];
                    j++;
                }
            }
            for(int i=0;i<nums.length;i++){
                nums[i]=output[i];
            }
        }

    public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    rotate(nums,3);
        System.out.println(Arrays.toString(nums));
        int[] num1={1,2};
        rotate(num1,1);
        System.out.println(Arrays.toString(num1));
    }
}
