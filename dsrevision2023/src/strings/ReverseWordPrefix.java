package strings;

public class ReverseWordPrefix {
        public static String reversePrefix(String word, char ch) {
            int index=-1;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)==ch){
                    index=i;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int j=index;j>=0;j--){
                sb.append(Character.toString(word.charAt(j)));
            }
            sb.append(word.substring(index+1));
            return sb.toString();
        }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefg",'d'));
    }

}
