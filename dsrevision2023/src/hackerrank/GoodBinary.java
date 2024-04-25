package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GoodBinary {

    public static void main(String[] args) {
        String s ="1100";
        String m = "100";
        List<String> strings = new ArrayList<>();
        strings.add(s);
        strings.add(m);
        strings.stream().max(Comparator.comparing(s1 -> s1.length()));
        int oneCount=0;
        int zeroCount=0;
        for(int i =0;i<s.length();i++){
            if("1".equals(s.charAt(i))){
                oneCount++;
            }else{
                zeroCount++;
            }
        }
    }
}
