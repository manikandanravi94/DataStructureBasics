package slidingwindow;

public class SlidingWindow {

    public static int maximumSum(int[] nums, int k){
        int maxSum=Integer.MIN_VALUE;
        int cSum=0;
        for(int i=0;i<k;i++){
            cSum+=nums[i];
            maxSum=cSum;
        }
        for(int i=k;i<nums.length;i++){
            cSum+=nums[i]-nums[i-k];
            if(cSum>maxSum){
                maxSum=cSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {1,2,5,17,3,15,2,8,9,11,2};
        System.out.println(maximumSum(input,3));
    }
}
