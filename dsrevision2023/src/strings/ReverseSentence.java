package strings;

public class ReverseSentence {

    public static String reverseWords(String s) {
        s=s.trim();
        StringBuilder output = new StringBuilder();
        while(s.length()>0){
            int index = s.lastIndexOf(" ");
            output.append(s.substring(index>0?index+1:0).trim()).append(" ");
            s=index>0?s.substring(0,index).trim():"";
        }
        return output.substring(0,output.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));
            }
}
