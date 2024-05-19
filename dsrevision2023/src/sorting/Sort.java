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

    private static void mergeSort(int[] nums){
        int size=nums.length;

        int[] output = divide(nums,0,size);
        System.out.println("merge sort : "+Arrays.toString(output));
    }

    public static int[] divide(int[] nums,int start, int end){
        int middle=(end-start)/2;
        if(nums.length==1){
            return nums;
        }

        int[] left=divide(getDivideArray(nums,0,middle),0,middle);
        int[] right=divide(getDivideArray(nums,middle,nums.length),middle,nums.length);
        return merge(left,right);
    }

    private static int[] getDivideArray(int[] nums, int start, int end) {
        int[] output = new int[end-start];
        int j=0;
        for(int i=start;i<end;i++){
            output[j]=nums[i];
            j++;
        }
        return output;
    }

    public static int[] merge(int[] left,int[] right){
        int leftLength=left.length;
        int rightLength=right.length;
        int[] output = new int[leftLength+rightLength];
        int i=0;
        int j=0;
        while(i+j<output.length){
            if(i>=leftLength){
                output[i+j]=right[j];
                j++;
            }
            else if(j>=rightLength){
                output[i+j]=left[i];
                i++;
            }
            else if(left[i]<right[j]){
                output[i+j]=left[i];
                i++;
            }else if(left[i]>right[j]){
                output[i+j]=right[j];
                j++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int [] nums = {8,1,4,3,5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        int[] insertSortInput={8,2,1,4,3};
        insertSort(insertSortInput);
        System.out.println(Arrays.toString(insertSortInput));
        mergeSort(new int[]{8,2,1,4,3});
    }


}
