package array.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(5%100);
        IntegerToRoman obj = new IntegerToRoman();
        System.out.println(obj.intToRoman(10));
    }

    public String intToRoman(int num) {
        int[] value = {1000, 500, 100, 50, 10, 5, 1};
        Map<Integer, String> romanMap = new HashMap();
        romanMap.put(1000, "M");
        romanMap.put(500, "D");
        romanMap.put(100, "C");
        romanMap.put(50, "L");
        romanMap.put(10, "X");
        romanMap.put(5, "V");
        romanMap.put(1, "I");
        romanMap.put(2, "II");
        romanMap.put(3, "III");
        StringBuilder sb = new StringBuilder();
        int divisor=1000;
        while(divisor>0){
            if(num/divisor>0){
                int maxIterator=num/divisor;
                String big="";
                String mid="";
                String small="";
                for(int i=0;i<value.length;i++){
                    if(num>=value[i]){
                        if(i==0 ){
                            big=romanMap.get(value[i]);
                            mid=romanMap.get(value[i]);
                            small=romanMap.get(value[i]);
                        break;
                        }
                        if(i==value.length-1){
                            big=romanMap.get(value[i-1]);
                            mid=romanMap.get(value[i-1]);
                            small=romanMap.get(value[i]);
                            break;
                        }
                        big=romanMap.get(value[i-1]);
                        mid=romanMap.get(value[i]);
                        small=romanMap.get(value[i+1]);
                        break;
                    }
                }
                if(maxIterator==9){
                    sb.append(small).append(big);
                }
                else if(maxIterator==4){
                    sb.append(small).append(mid);
                }
                else if(maxIterator==1){
                    sb.append(mid);
                }
                else{
                    if(maxIterator>=5){
                        sb.append(mid);
                    }
                    int iterator=maxIterator>=5?maxIterator-5:maxIterator;
                    for(int i=0;i<iterator;i++){
                      sb.append(small);
                    }
                }
                num=num%divisor;
            }
                divisor=divisor/10;
        }
        return sb.toString();
    }

//    public String intToRoman(int num) {
//        int[] value = {1000, 500, 100, 50, 10, 5, 1};
//        Map<Integer, String> romanMap = new HashMap();
//        romanMap.put(1000, "M");
//        romanMap.put(500, "D");
//        romanMap.put(100, "C");
//        romanMap.put(50, "L");
//        romanMap.put(10, "X");
//        romanMap.put(5, "V");
//        romanMap.put(1, "I");
//        romanMap.put(2, "II");
//        romanMap.put(3, "III");
//        StringBuilder sb = new StringBuilder();
//        if (num / value[0] > 0) {
//            for (int k = 0; k < num / value[0]; k++) {
//                sb.append(romanMap.get(value[0]));
//            }
//            num = num % value[0];
//        }
//            for (int i = 2; i < value.length; i=i+2) {
//                if (num /value[i]>0) {
//                    String big=romanMap.get(value[i]);
//                    String small=romanMap.get(value[i]);
//                    int max=num/value[i];
//                    if(num>value[i-1]){
//                        big=romanMap.get(value[i-2]);
//                        max=num/value[i]-5;
//
//                    }
//                    for (int j = 0; j < max; j++) {
//                        if (max == 4) {
//                            sb.append(small).append(big);
//                            break;
//                        }
//                        sb.append(small.length()>0?small:big);
//                    }
//                    num=num%value[i];
//                }
//            }
//        return sb.toString();
//    }
}
