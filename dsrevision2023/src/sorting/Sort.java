package sorting;

import java.util.Arrays;

public class Sort {

    public static void bubbleSort(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(nums[j]>nums[i]){
                    int temp = nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
    }

    private static void insertSort(int[] num) {
        for(int i=1;i<num.length;i++){
            int current =num[i];
            int insertIndex=0;
            for(int j=i;j>0;j--){
                if(current<num[j-1]){
                    num[j]=num[j-1];
                }else{
                    insertIndex=j;
                    break;
                }
            }
            num[insertIndex]=current;
        }
    }

    public static void main(String[] args) {
        int [] nums = {8,1,4,3,5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        int[] insertSortInput={8,2,1,4,3};
        insertSort(insertSortInput);
        System.out.println(Arrays.toString(insertSortInput));
    }


}
