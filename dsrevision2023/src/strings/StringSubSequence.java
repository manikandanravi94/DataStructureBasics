package strings;

import java.util.ArrayList;
import java.util.List;

public class StringSubSequence {

    public static List<String> elements = new ArrayList<>();

    public static void gss(String input, String ans){
        if(input.length()==0){
            elements.add(ans);
            return;
        }
        gss(input.substring(1),ans+input.charAt(0));
        gss(input.substring(1),ans);
    }

    public static void main(String[] args) {
        String input="abc";
        gss(input,"");
        System.out.println(elements);
    }
}
