package bitmanipulation;

import java.math.BigInteger;

public class AddBinary {

    public static void main(String[] args) {
//        System.out.println(addTwoBinaires("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
/* wrong approach
    public static String addTwoBinaires(String a, String b){
        BigInteger k= BigInteger.valueOf(0);
        BigInteger m= BigInteger.valueOf(0);
        int j=0;
        int l=0;
        for(int i=a.length()-1;i>=0;i--){
            System.out.println(a.charAt(i));
            BigInteger temp = BigInteger.valueOf (Math.pow(2,j)*Character.getNumericValue(a.charAt(i))));
            k=k.add(temp);
            j++;
        }
        for(int i=b.length()-1;i>=0;i--){
            long temp =  (long)(Math.pow(2,l)*Character.getNumericValue(b.charAt(i)));
            m=m+temp;
            l++;
        }
        double total = k+m;
        String output="";
        while(total/2!=0){
            output=total%2+output;
            total=total/2;
        }
        output=total%2+output;
        return output;
    }
    */

}
