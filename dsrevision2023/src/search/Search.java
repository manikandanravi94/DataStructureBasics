package search;

public class Search {


    public static int binarySearch(int[] nums, int k){

        int output=binarySearch(nums,0,nums.length,k);
        return output+1;
    }

    private static int binarySearch(int[] nums, int start, int end,int k) {
        int middle=(start+end)/2;
        if(nums[middle]==k){
            return middle;
        }
        if(nums[middle]>k){
            end=middle;
        }else{
            start=middle;
        }
        return binarySearch(nums,start,end,k);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2,3,5,7,8,9,11,15,17,19},17));
    }
}
