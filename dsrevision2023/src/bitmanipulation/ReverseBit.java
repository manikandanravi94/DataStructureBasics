package bitmanipulation;

public class ReverseBit {

    public static void main(String[] args) {
        int k = 2147483647;
        int l = 1073741826;
        System.out.println(k+l);
//        System.out.println(reverseBits("11111111111111111111111111111101"));
    }

    public static int reverseBits(String n) {
        String k = String.valueOf(n);
        Integer output = 0;
        for (int i = 0; i < k.length(); i++) {
            int o = (Character.getNumericValue(k.charAt(i)) * (int) Math.pow(2, i));
            System.out.println(o);
            output = output + o;
        }
        return output;
    }
}
